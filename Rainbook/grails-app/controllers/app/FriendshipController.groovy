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
            System.out.println(parties[1])
        }

        // Retrieve the ID of the other party from friendList2
        for(Friendship f : friendList2)
        {
            String[] parties2 = f.toString().split(",")
            completeFriendIDList.add(parties2[0])
            System.out.println(parties2[0])
        }

        def completeFriendList = new ArrayList()
        // For each user ID, retrieve name, email and photo of friend
        for(String s : completeFriendIDList)
        {
            completeFriendList.add( Profile.findById(s) )
        }

        def currentUser = Profile.findById( session.userid )

        // def c = friendList + friendList2
        [friends: completeFriendList, currentUser: currentUser]
    }

    def delete =
    {
        def friendID = params.id

        if( session.userid == friendID )
        {
            flash.message = "An error occured while deleting the friend."
            redirect(action: "list")
        }

        def friendToBeRemoved = Friendship.findByPartiesLike(friendID + ",%")
        if(friendToBeRemoved == null)
        {
            friendToBeRemoved = Friendship.findByPartiesLike( "%," + friendID )
        }

        if( friendToBeRemoved!= null )
        {
            friendToBeRemoved.delete();
            flash.message = "Friend Deleted!"
            redirect(action: "list")
        }
        else
        {
            flash.message = "An error occured while deleting the friend."
            redirect(action: "list")
        }

    }
    
}