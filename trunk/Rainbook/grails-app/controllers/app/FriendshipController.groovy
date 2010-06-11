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
        def completeFriendList = friendList + friendList2
        render(completeFriendList)
    }
    
}
