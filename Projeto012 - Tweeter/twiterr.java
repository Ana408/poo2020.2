import java.util.*;
import java.util.Scanner;


class Tweet{
    int id;
    String username;
    String msg;
    TreeSet<String> likes;
    public Tweet(int id, String username, String msg){
        this.id = id;
        this.username = username;
        this.msg = msg;
        this.likes = new TreeSet<String>();
    }
    public void like(String username){
        for(String user : likes)
            if(user.equals(username))
                return;
        likes.add(username);
    }
    public String toString(){
        String saida = "";
        saida += "id: " + this.id + "Nome: " + this.username + "Mensagem: " +"( " + this.msg + ")";
        if(likes.size() > 0){
            saida += "[ ";
            for(String user : this.likes)
                saida += user + " ";
            saida += "]";
        }
        return saida;
    }
}

class User{
    String username;
    ArrayList<Tweet> timeline; 
    TreeMap<String, User> followers;
    TreeMap<String, User> following;
    int unreadCount;
    public User(String id){
        this.username = id;
        unreadCount = 0;
        timeline  = new ArrayList<Tweet>();
        followers = new TreeMap<String, User>();
        following = new TreeMap<String, User>();   
    }
    public void follow(User other){
        if(following.containsKey(other.username)){
            throw new RuntimeException("fail: já está seguindo");
        }
        this.following.put(other.username, other);
        other.followers.put(this.username, this);
    }
    public void unfollow(String username){
        if(!following.containsKey(username)){
            throw new RuntimeException("fail: voce não é seguidor");
        }
        User other = following.get(username);
        this.following.remove(username);
        other.followers.remove(this.username);
    }
    public Tweet getTweet(int id){
        for(Tweet twteet : timeline){
            if(twteet.id == id)
                return twteet;
        }
        throw new RuntimeException("fail: Tweet não encontrado");
    }
    public void sendTweet(Tweet twteet){
        this.timeline.add(twteet);
        for(User user : followers.values()){
            user.timeline.add(twteet);
            user.unreadCount += 1;
        }
    }
    public String getTimeline(){
        String saida = "";
        for(Tweet twteet : this.timeline)
            saida += twteet;
        return saida;
    }
    public String getUnread(){
        String saida = "";
        for(int i = timeline.size() - unreadCount; i < timeline.size(); i++)
            saida += timeline.get(i);
        unreadCount = 0;
        return saida;
    }
    public String toString(){
        return "Nome: " + this.username;
    }
}

class Controller{
    TreeMap<String, User> users;
    TreeMap<Integer, Tweet> tweets;
    int nextTwT = 0;
    public Controller(){
        users = new TreeMap<String, User>();
    }
    public void sendTweet(String username, String msg){
        User user = this.getUser(username);
        Tweet twteet = new Tweet(nextTwT++, username, msg);
        user.sendTweet(twteet);
    }
    public void addUser(String username){
        User user = users.get(username);
        if(user == null){
            users.put(username, new User(username));
        }
        return;
    }
    public User getUser(String username){
        User user = users.get(username);
        if(user == null){
            throw new RuntimeException("fail: O usuario não encontrado");
        }
        return user;
    }
    public String toString(){
        String saida = "";
        for(User user : users.values())
            saida += user;
        return saida;
    }
}
public class twiterr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller sistema = new Controller();
        
        while(true){
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            try {
                if (ui[0].equals("end"))
                    break;
                else if (ui[0].equals("addUser")) {
                    sistema.addUser(ui[1]);
                } else if (ui[0].equals("show")) {
                    System.out.print(sistema);
                } else if (ui[0].equals("follow")) {//goku tina
                    User one = sistema.getUser(ui[1]);
                    User two = sistema.getUser(ui[2]);
                    one.follow(two);
                }
                else if (ui[0].equals("twittar")) {
                    String username = ui[1];
                    String msg = "";
                    for(int i = 2; i < ui.length; i++)
                        msg += ui[i] + " ";
                    sistema.sendTweet(username, msg);
                }
                else if (ui[0].equals("timeline")) {
                    User user = sistema.getUser(ui[1]);
                    System.out.print(user.getTimeline());
                }
                else if (ui[0].equals("like")) {
                    User user = sistema.getUser(ui[1]);
                    Tweet tw = user.getTweet(Integer.parseInt(ui[2]));
                    tw.like(ui[1]);
                }else if (ui[0].equals("unfollow")) {
                    User user = sistema.getUser(ui[1]);
                    user.unfollow(ui[2]);
                }else{
                    throw new RuntimeException("fail: comando invalido");
                }
            }catch(RuntimeException rt){
                System.out.println(rt.getMessage());
            }
        }
        scanner.close();
    }
}
