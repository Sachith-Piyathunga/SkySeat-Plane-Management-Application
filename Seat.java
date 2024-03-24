//w2053013 - Sachintha chamod
//Define a class name as seat to represent a seat in plane
class Seat
{
    int value; //get an integer variable to represent the availability of the seat.

    Seat() {
        this.value = 0;
    }  //method for initializing the value of the seat to 0.

    void sellSeat() {
        this.value = 1;
    } //add method to mark the seat as sold, setting value to 1.

    void freeSeat() {
        this.value = 0;
    } //add method to mark the sea as free, setting value to 0.

    boolean isAvailable() {
        return this.value == 0;
    } //method to check seat availability, returning ture if value is 0.
}