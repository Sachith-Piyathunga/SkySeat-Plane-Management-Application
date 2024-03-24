//w2053013 - Sachintha  chamod
//define a class name as Person to represent person info in ticket
class Person
{
    //declare a variable to store person information
    private String name; //name of the person
    private String surname; //surname of the person
    private String email; //email of the person

    //add method for initializing person information
    Person(String name, String surname, String email)
    {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    //method for access private member variable
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    //set method to modify private member variable
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //method to print person information
    void printPersonInfo()
    {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Email: " + email);
    }
}