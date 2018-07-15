package com.ducdungdam.dartfriends.utilities;

import com.ducdungdam.dartfriends.model.GameMode;
import com.ducdungdam.dartfriends.model.User;
import java.util.ArrayList;
import java.util.List;

public class FakeDataUtils {

  public static User getUser() {
    return new User(0, "Duc Dung", "https://pbs.twimg.com/profile_images/529025886792593408/kThWCIad.jpeg");
  }

  public static List<User> getUserList() {
    List<User> userList = new ArrayList<>();
    userList.add(getUser());
    userList.add(new User(1, "Robin", "https://avatarfiles.alphacoders.com/100/100990.jpg"));
    userList.add(new User(2, "Roth", "https://avatarfiles.alphacoders.com/782/78200.png"));
    userList.add(new User(3, "John", "https://avatarfiles.alphacoders.com/623/thumb-62373.jpg"));
    userList.add(new User(4, "Greg",
        "https://orig00.deviantart.net/2fe5/f/2015/065/a/4/avatar_ultimate_son_gohan_form__dragon_ball__by_raidenakuma-d8kn16h.png"));
    userList.add(new User(5, "Mutti", "https://avatarfiles.alphacoders.com/584/58469.png"));
    userList.add(new User(6, "Pappi",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeSzVgbe7d-8FYJcioN9QCnuGLBVESEoPII5o784ZoG0n486GK"));
    userList.add(new User(7, "Omi", "https://avatarfiles.alphacoders.com/688/thumb-68801.jpg"));
    userList.add(new User(8, "Opi", "https://avatarfiles.alphacoders.com/107/107813.jpg"));

    return userList;
  }

  public static List<GameMode> getGameModeList() {
    List<GameMode> gamemodeList = new ArrayList<>();
    gamemodeList.add(new GameMode(0,"301: Single Out","Each player starts with 501 points. The number of points collected while hitting a board with a dart is subtracted from the given player's points. The winner is the player who scores exactly 0 points that way.","301 Darts Game\n"
        + "This game is the same game as 801 and 501 darts, just with fewer starting points. Having less points to start will make the game much shorter but it also doesn't allow much room for error. If you get behind in 301 darts it is hard to catch back up before the other team goes out and wins the game. It can be played with any number of individual players or teams where you rotate every other turn.\n"
        + "Rules for How to Play 301 Darts\n"
        + "Start by flipping a coin or shooting a dart for closest to bulls eye in order to determine who goes first. Each team will throw 3 darts per turn but the trick to this game is you must hit a double in order to officially start collecting points and also must hit a double to win the game. Hitting  a double consists of the very outside ring on the board or a double bulls eye on the very center. Once you hit your first double, those points count and you total your points to count down from 301. \n"
        + "\n"
        + "Most players aim for triple 20s as it offers 60 total points and if you miss you are likely to still hit a single 20. You must also hit a double for your last throw in order to win. Once you score at least 101 points, you will be down under 100 and you should look at an out chart to help you strategize for your final throws. If you go under zero by scoring too many points or hit zero without scoring a double, you go bust. When you go bust you must forfeit the rest of your turn and restart the next turn with the same amount of points you started the last round with.\n"
        + "Reading the Out Chart\n"
        + "The Out Chart is used to help you quickly select what to aim for when you have 100 points or less. Based on your remaining points out of the 301 total, look at the bold numbers on the chart to determine what you should aim for in order to close out the game. If you have 80 points left, you will see the best way to go out is hit a T16 (triple 16) and a D16 (double 16). This will total 80 points and your last throw is a double, so you would win the game. You will notice that every final throw on the chart requires a D for double because you are required to score a double to get out. We highly recommend that you purchase an out chart so you can play '01 games if your dartboard didn't come with one.", "https://images.pexels.com/photos/262438/pexels-photo-262438.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"));
    gamemodeList.add(new GameMode(1,"301: Double Out","Each player starts with 501 points. The number of points collected while hitting a board with a dart is subtracted from the given player's points. The winner is the player who scores exactly 0 points that way.","Each player starts with a score of 301 and takes turns to throw 3 darts.  The score for each turn is calculated and deducted from the players total.  Bullseye scores 50, the outer ring scores 25 and a dart in the double or treble ring counts double or treble the segment score.  The objective is to be the first player to reduce the score to exactly zero, the only caveat being that the last dart thrown must land in a double or the bullseye.", "https://images.pexels.com/photos/262438/pexels-photo-262438.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"));
    gamemodeList.add(new GameMode(2,"501: Single Out","Each player starts with 501 points. The number of points collected while hitting a board with a dart is subtracted from the given player's points. The winner is the player who scores exactly 0 points that way.","Each player starts with a score of 501 and takes turns to throw 3 darts.  The score for each turn is calculated and deducted from the players total.  Bullseye scores 50, the outer ring scores 25 and a dart in the double or treble ring counts double or treble the segment score.  The objective is to be the first player to reduce the score to exactly zero, the only caveat being that the last dart thrown must land in a double or the bullseye.", "https://images.pexels.com/photos/262438/pexels-photo-262438.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"));
    gamemodeList.add(new GameMode(3,"501: Double Out","Each player starts with 501 points. The number of points collected while hitting a board with a dart is subtracted from the given player's points. The winner is the player who scores exactly 0 points that way.","Each player starts with a score of 501 and takes turns to throw 3 darts.  The score for each turn is calculated and deducted from the players total.  Bullseye scores 50, the outer ring scores 25 and a dart in the double or treble ring counts double or treble the segment score.  The objective is to be the first player to reduce the score to exactly zero, the only caveat being that the last dart thrown must land in a double or the bullseye.", "https://images.pexels.com/photos/262438/pexels-photo-262438.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"));
    gamemodeList.add(new GameMode(4,"Around the Clock","Each player starts with 501 points. The number of points collected while hitting a board with a dart is subtracted from the given player's points. The winner is the player who scores exactly 0 points that way.","A popular game played for fun is \"Around the Clock\".  In this, each player takes turns to throw 3 darts and is required to throw a dart in every segment starting from 1 up to 20 and then to finish with the 25 and bullseye.  Players must start with 1 and cannot proceed to the next number until a dart has been successfully thrown at the current target segment.  Doubles and trebles are ignored.  First player to hit all the targets and then...", "https://images.pexels.com/photos/262438/pexels-photo-262438.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"));
    gamemodeList.add(new GameMode(5,"Killer","Each player starts with 501 points. The number of points collected while hitting a board with a dart is subtracted from the given player's points. The winner is the player who scores exactly 0 points that way.","Killer This is the most popular game for large groups and is good swift fun. There are variations but this is the basic game. To begin, an order of play is decided, and each player throws one dart 'bad-handed' (left-handed players throw right-handed and vice-versa) at the board to decide their number. Obviously, if a dart misses or hits a number that is already allocated, the player retries. Each player is allocated a set number of lives ...", "https://images.pexels.com/photos/262438/pexels-photo-262438.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"));

    return  gamemodeList;
  }
}

