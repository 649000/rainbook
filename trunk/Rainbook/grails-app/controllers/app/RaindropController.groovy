package rainbook
import grails.converters.JSON

class RaindropController {

    def index = { }

    def save ={
        
    }

    def retrieve = {
        Thread.sleep(2000)
        def raindrop = Raindrop.get(params.Id);
        if (horoscope) {
            render horoscope as JSON
        } else {
            render ''
        }
    }

    def list = {
        Thread.sleep(2000)
        def raindropList = Raindrop.findAll()
        render raindropList as JSON
    }
}
