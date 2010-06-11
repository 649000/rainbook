package app

class Profile {

    static constraints =
    {
          email(blank:false)
        password(blank:false)
        name(blank:false)
        photo(blank:false)
    }

    static hasMany = [raindrop:Raindrop]

    String email
    String password
    String name
    String photo

        String toString()
    {
        return name
    }

}
