package app

class FriendshipController
{

    def index =
    {
        session.userid = 1
        redirect(action: "list")
    }

    def list =
    {
        def friendList = Friendship.findAllByPartiesLike( session.userid + ",%")
        def friendList2 = Friendship.findAllByPartiesLike( "%," + session.userid )

        def completeFriendIDList = new ArrayList();
        
        // Retrieve the ID of the other party from friendList
        for(Friendship f : friendList)
        {
            String[] parties = f.toString().split(",")
            completeFriendIDList.add(parties[1])
        }

        // Retrieve the ID of the other party from friendList2
        for(Friendship f : friendList2)
        {
            String[] parties = f.toString().split(",")
            completeFriendIDList.add(parties[0])
        }

        def completeFriendList = new ArrayList()
        // For each user ID, retrieve name, email and photo of friend
        for(String s : completeFriendIDList)
        {
            completeFriendList.add( Profile.findById(s) )
        }

        // def c = friendList + friendList2
        render(view: "list", model: [friends: completeFriendList] )
    }
    
}