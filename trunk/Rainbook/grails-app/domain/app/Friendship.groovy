package app

class Friendship
{

    static constraints =
    {
        // add constraints here
        // id1 cannot be = id2
    }

    static belongsTo = [profile:Profile]
    static hasMany = [profiles:Profile]

    int id1
    int id2

}
