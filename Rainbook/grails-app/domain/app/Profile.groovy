package app

class Profile {

    static constraints =
    {
        // add constraints here
        // email must be a valid email
    }

    static hasMany = [raindrop:Raindrop, friends:Profile]
    static belongsTo = [profile:Profile]

    String email
    String password
    String name
    String photo

}
