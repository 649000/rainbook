package app

class Raindrop
{

    static constraints =
    {
        // add constraints here
        // text must be of at least a certain length
    }

    static belongsTo = [profile:Profile]

    int id
    String text

}
