package app

class ProfileController {

    def index = {
        redirect (action: "create")
    }

    def create =
    {
        def profile = new Profile(params)
        return [profile: profile]
    }

    def show =
    {
        def profile = Profile.get(params.id)
        return [profile: profile]
    }

    def save = {

        def profile = new Profile(params)
                
        def uploadedFile = request.getFile('photo')

        profile.photo = uploadedFile.originalFilename

        if (profile.save()) { // Save Domain Class

           

            def webRootDir = servletContext.getRealPath("/")

            def userDir = new File(webRootDir, "/photo")
            userDir.mkdirs()

            // Save file contents into a new file in “/photo” folder.
            
            uploadedFile.transferTo(new File(userDir,uploadedFile.originalFilename))
            
            redirect(action: "show", id: profile.id)
        }

        else {

            render(view: "create", model: [profile: profile])
        }
    }
        def delete =
    {
        def profile = profile.get(params.id)
        entry.delete()
        redirect(action:"create")
    }
    

}
        
