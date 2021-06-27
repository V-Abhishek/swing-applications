/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lab7.entities.Comment;
import lab7.entities.Post;
import lab7.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {

    // find user with Most Likes
    // TODO
    public void userWithMoreLikes() {
        Map<Integer, Integer> userLikesCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        for (User user : users.values()) {
            for (Comment comment : user.getComments()) {
                int likes = 0;
                if (userLikesCount.containsKey(user.getId())) {
                    likes = userLikesCount.get(user.getId());
                    likes += comment.getLikes();
                    userLikesCount.put(user.getId(), likes);
                }
            }
        }
        int max = 0;
        int maxId = 0;
        for (Integer id : userLikesCount.keySet()) {
            if (userLikesCount.get(id) > max) {
                max = userLikesCount.get(id);
                maxId = id;
            }
        }

        System.out.println("User with most likes: " + max + "\n" + users.get(maxId));
    }

    // find 5 comments which have the most likes
    // TODO
    public void giveFiveMostLikedComment() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        Collections.sort(commentList, new Comparator<Comment>() {
            public int compare(Comment o1, Comment o2) {
                return o2.getLikes() - o1.getLikes();
            }
        });

        System.out.println("5 most likes comment:");
        for (int i = 0; i < commentList.size() && i < 5; i++) {
            System.out.println(commentList.get(i));
        }
    }

    // Post with most comments.
    public void getPostWithMostComments() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        List<Post> postList = new ArrayList<>(posts.values());
        int maxComments = 0;
        for (Post p : postList) {
            if (p.getComments().size() > maxComments) {
                maxComments = p.getComments().size();
            }
        }
        System.out.println("Posts/Post with Most Comments");
        for (Post post : postList) {
            if (post.getComments().size() == maxComments) {
                System.out.println("Post ID " + post.getPostId() + ". Number of comments: " + post.getComments().size());
            }
        }
    }

    // Average number of likes per comments
    public void getAverageNumberOfLikesPerComment() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        List<Post> postList = new ArrayList<>(posts.values());
        int numberOfComments = 0;
        int numberOfLikes = 0;
        for (Post post : postList) {
            numberOfComments += post.getComments().size();
            List<Comment> commentList = new ArrayList<>(post.getComments());
            for (Comment comment : commentList) {
                numberOfLikes += comment.getLikes();
            }
        }
        System.out.println("Average Number of Likes Per Comment");
        System.out.println("Number of Likes: " + numberOfLikes);
        System.out.println("Number of Comments: " + numberOfComments);
        System.out.println("Average number of likes per comment(Integer): " + (numberOfLikes / numberOfComments));
        float res = (float)numberOfLikes/numberOfComments;
        System.out.println("Average number of likes per comment(Decimal): " + res);
    }

    //Top 5 Proactive / Inactive Users
    public void activeInactiveUsers() {
        System.out.println();
        Map<Integer, Integer> activeInactive = new HashMap<>();
        int sum = 0;
        for (Map.Entry<Integer, User> user : DataStore.getDataStore().getUsers().entrySet()) {
            sum = user.getValue().getComments().size();
            for (Map.Entry<Integer, Post> post : DataStore.getDataStore().getPosts().entrySet()) {
                if (user.getValue().getId() == post.getValue().getUserId()) {
                    sum++;
                    for (Comment comment : post.getValue().getComments()) {
                        sum++;
                        sum += comment.getLikes();
                    }
                }
            }
            activeInactive.put(user.getValue().getId(), sum);
        }
        System.out.println("Top 5 Proactive Users (sum of comments, posts and likes)");
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(activeInactive.entrySet());
        Collections.sort(list, (Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) -> o2.getValue() - o1.getValue());
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> e : list) {
            temp.put(e.getKey(), e.getValue());
        }
        temp.entrySet().stream().limit(5).forEach(e -> System.out.println(DataStore.getDataStore().getUsers().get(e.getKey()) + " Sum:" + e.getValue()));
        System.out.println();
        System.out.println("Top 5 Inactive Users (sum of comments, posts and likes)");
        list = new LinkedList<Map.Entry<Integer, Integer>>(activeInactive.entrySet());
        Collections.sort(list, (Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) -> o1.getValue() - o2.getValue());
        temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> e : list) {
            temp.put(e.getKey(), e.getValue());
        }
        temp.entrySet().stream().limit(5).forEach(e -> System.out.println(DataStore.getDataStore().getUsers().get(e.getKey()) + " Sum:" + e.getValue()));
    }
    
    //HashMap sort for Post and Comment
    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> toBeSortedMap) {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(toBeSortedMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                    Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            sortedMap.put(aa.getKey(), aa.getValue());
        }
        return sortedMap;
    }

    //Top 5 inactive users based on total number of posts
    public void getFiveInactiveUsersBasedOnPosts() {
        HashMap<Integer, Integer> preResultMap = new HashMap<>();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        for (Post value0 : posts.values()) {
            int userId = value0.getUserId();
            int count = 0;
            for (Post value1 : posts.values()) {
                if (value1.getUserId() == userId) {
                    count += 1;
                }
            }
            preResultMap.put(userId, count);
            count = 0;
        }
        HashMap<Integer, Integer> resultMap = sortByValue(preResultMap);
        Set<Integer> keys = resultMap.keySet();
        Iterator<Integer> keyIterator = keys.iterator();
        int top = 5;
        System.out.println("Top 5 inactive Users based on total number of Posts:");
        while (keyIterator.hasNext() && top > 0) {
            Integer userId = keyIterator.next();
            User user = null;
            user = users.get(userId);
            System.out.println(user);
            --top;
        }
    }
	
	// The post with most liked comments.
    public void getPostWithMostLikedComments() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, Integer> preResultMap = new HashMap<Integer, Integer>();
        int mostLikes = 0;
        for (Post post : posts.values()) {
            int totalLikesForPost = 0;
            List<Comment> comments = post.getComments();
            for (Comment comment : comments) {
                totalLikesForPost += comment.getLikes();
            }
            preResultMap.put(post.getPostId(), totalLikesForPost);
            if (totalLikesForPost > mostLikes) {
                mostLikes = totalLikesForPost;
            }
        }
        System.out.println("Post/posts with most liked comments");
        Set<Integer> keys = preResultMap.keySet();
        Iterator<Integer> keyIterator = keys.iterator();
        while (keyIterator.hasNext()) {
            Integer key = keyIterator.next();
            int value = preResultMap.get(key);
            if (value == mostLikes) {
                System.out.println("Post Id: " + key + ". Total number of likes for all the comments: " + value);
            }

        }
    }
    
    //Top 5 inactive users based on total number of comments
    public void getFiveInactiveUsersBasedOnComments() {
        HashMap<Integer, Integer> preResultMap = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        for (User user : users.values()) {
            preResultMap.put(user.getId(), user.getComments().size());
        }
        HashMap<Integer, Integer> rstMap = sortByValue(preResultMap);
        Set<Integer> keys = rstMap.keySet();
        Iterator<Integer> keyIterator = keys.iterator();
        int tp = 5;
        System.out.println("Top 5 inactive Users based on total number of Comments:");
        while (keyIterator.hasNext() && tp > 0) {
            Integer usrId = keyIterator.next();
            User usr = null;
            usr = users.get(usrId);
            System.out.println(usr);
            --tp;
        }
    }
    
    //The Post with a higest liked comment
    public void getPostWithhighestLikedComment() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, Integer> preResultMap = new HashMap<Integer, Integer>();
        int mostLikes = 0;
        for (Post post : posts.values()) {
            List<Comment> comments = post.getComments();
            int highestLike = 0;
            for (Comment comment : comments) {
                if (comment.getLikes() > highestLike) {
                    highestLike = comment.getLikes();
                }
            }
            preResultMap.put(post.getPostId(), highestLike);
            if (highestLike > mostLikes) {
                mostLikes = highestLike;
            }
        }
        System.out.println("Post with most liked comment");
        Set<Integer> keys = preResultMap.keySet();
        Iterator<Integer> keyIterator = keys.iterator();
        while (keyIterator.hasNext()) {
            Integer key = keyIterator.next();
            int value = preResultMap.get(key);
            if (value == mostLikes) {
                System.out.println("Post Id: " + key + ". Highest number of likes: " + value);
            }
        }
    }
}
