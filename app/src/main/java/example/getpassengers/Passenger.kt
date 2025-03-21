package example.getpassengers

class Passenger(val lName:String, val fName: String, val phone: String) {
    override fun toString(): String {
        var s = "<<" + this.fName + " " + this.lName + " " + this.phone + ">>"
        return s
    }
}