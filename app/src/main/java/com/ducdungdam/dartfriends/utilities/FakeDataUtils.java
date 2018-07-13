package com.ducdungdam.dartfriends.utilities;

import com.ducdungdam.dartfriends.model.GameMode;
import com.ducdungdam.dartfriends.model.User;
import java.util.ArrayList;
import java.util.List;

public class FakeDataUtils {

  public static User getUser() {
    return new User(1, "Duc Dung", "https://pbs.twimg.com/profile_images/529025886792593408/kThWCIad.jpeg");
  }

  public static List<User> getUserList() {
    List<User> userList = new ArrayList<>();
    userList.add(getUser());
    userList.add(new User(2, "Robin", "https://avatarfiles.alphacoders.com/100/100990.jpg"));
    userList.add(new User(3, "Roth", "https://avatarfiles.alphacoders.com/782/78200.png"));
    userList.add(new User(4, "John", "https://avatarfiles.alphacoders.com/623/thumb-62373.jpg"));
    userList.add(new User(5, "Greg",
        "https://orig00.deviantart.net/2fe5/f/2015/065/a/4/avatar_ultimate_son_gohan_form__dragon_ball__by_raidenakuma-d8kn16h.png"));
    userList.add(new User(6, "Mutti", "https://avatarfiles.alphacoders.com/584/58469.png"));
    userList.add(new User(7, "Pappi",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeSzVgbe7d-8FYJcioN9QCnuGLBVESEoPII5o784ZoG0n486GK"));
    userList.add(new User(8, "Omi", "https://avatarfiles.alphacoders.com/688/thumb-68801.jpg"));
    userList.add(new User(9, "Opi", "https://avatarfiles.alphacoders.com/107/107813.jpg"));

    return userList;
  }

  public static List<GameMode> getGameModeList() {
    List<GameMode> gamemodeList = new ArrayList<>();
    gamemodeList.add(new GameMode("301: Single Out", "Each player starts with a score of 301 and takes turns to throw 3 darts.  The score for each turn is calculated and deducted from the players total.  Bullseye scores 50, the outer ring scores 25 and a dart in the double or treble ring counts double or treble the segment score.  The objective is to be the first player to reduce the score to exactly zero, the only caveat being that the last dart thrown must land in a double or the bullseye."));
    gamemodeList.add(new GameMode("301: Double Out", "Each player starts with a score of 301 and takes turns to throw 3 darts.  The score for each turn is calculated and deducted from the players total.  Bullseye scores 50, the outer ring scores 25 and a dart in the double or treble ring counts double or treble the segment score.  The objective is to be the first player to reduce the score to exactly zero, the only caveat being that the last dart thrown must land in a double or the bullseye."));
    gamemodeList.add(new GameMode("501: Single Out", "Each player starts with a score of 501 and takes turns to throw 3 darts.  The score for each turn is calculated and deducted from the players total.  Bullseye scores 50, the outer ring scores 25 and a dart in the double or treble ring counts double or treble the segment score.  The objective is to be the first player to reduce the score to exactly zero, the only caveat being that the last dart thrown must land in a double or the bullseye."));
    gamemodeList.add(new GameMode("501: Double Out", "Each player starts with a score of 501 and takes turns to throw 3 darts.  The score for each turn is calculated and deducted from the players total.  Bullseye scores 50, the outer ring scores 25 and a dart in the double or treble ring counts double or treble the segment score.  The objective is to be the first player to reduce the score to exactly zero, the only caveat being that the last dart thrown must land in a double or the bullseye."));
    gamemodeList.add(new GameMode("Around the Clock", "A popular game played for fun is \"Around the Clock\".  In this, each player takes turns to throw 3 darts and is required to throw a dart in every segment starting from 1 up to 20 and then to finish with the 25 and bullseye.  Players must start with 1 and cannot proceed to the next number until a dart has been successfully thrown at the current target segment.  Doubles and trebles are ignored.  First player to hit all the targets and then..."));
    gamemodeList.add(new GameMode("Killer", "Killer This is the most popular game for large groups and is good swift fun. There are variations but this is the basic game. To begin, an order of play is decided, and each player throws one dart 'bad-handed' (left-handed players throw right-handed and vice-versa) at the board to decide their number. Obviously, if a dart misses or hits a number that is already allocated, the player retries. Each player is allocated a set number of lives ..."));

    return  gamemodeList;
  }
}

