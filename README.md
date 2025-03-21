GetPassengers is an app that allows users to create a list of passengers by entering their first name, last name, and phone number. The app consists of two main screens that work together to collect and display passenger information.
MainActivity (First Screen): This is the starting point of the app. It displays the title "GET PASSENGER LIST" using a TextView and includes a button that takes users to the second screen, where they can enter passenger details. Once passengers are added, this screen retrieves and displays the finalized list.


GetPassengers Activity (Second Screen): This is where users input their first name, last name, and phone number using EditText fields. It has two buttons—one to add a passenger to the list and another to return to the first screen with the completed list. The entered data is stored in a list and sent back to the MainActivity using intents.


The app ensures that all added passengers are displayed on the main screen after returning from the second screen. By structuring the app this way, users can easily add, view, and manage their passenger list in an intuitive way.


During this project, I ran into a few challenges. One of the biggest obstacles was getting the return button to take me back to the first screen without crashing the app. Every time I pressed it, the app would crash, and I couldn’t figure out why at first. Eventually, I realized that I wasn’t properly passing the data back through the intent. Once I fixed that by making sure the list was correctly stored and sent back, the button worked as expected.
Another issue I ran into was that when I added a passenger, the list wasn’t accumulating properly. After some troubleshooting, I realized that I had two problems: first, I hadn’t linked the button correctly, so it wasn’t triggering the function as intended. Second, I didn’t set up the loop properly to store and update the list. Once I corrected those mistakes, the list successfully updated and displayed all added passengers.


One of the biggest things I learned during this project was how to pass data between activities using intents. Before this, I didn’t fully understand how to send and receive data properly, but now I see how important it is to structure it correctly so everything updates as expected.
I also got more comfortable working with Kotlin, especially figuring out small but important details, like setting up loops correctly and making sure buttons are actually linked to their functions. Debugging was a huge part of the process, and I learned that small mistakes—like not updating a variable or missing a connection—can break everything.
On the XML side, I learned how to use ConstraintLayout to properly position elements. Before, I didn’t know how to align EditText fields, but I figured out how to place them next to each other by adjusting constraints. I also finally understood margins—before, I didn’t really get what they did, but now I see how they help space out elements to make the layout look better and more readable
If I had more time, I would definitely add a way to edit or delete passengers before submitting the final list. Right now, once you add a passenger, there’s no way to fix mistakes or remove someone, which isn’t very practical.
