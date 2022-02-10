# CS321-Group11
- Shawn Burnham

- James Haywood

- Jarred Long

- Justin Bushue

## Class/Work Schedules
[Class/Work Schedules](https://docs.google.com/spreadsheets/d/1Zj6V2qRDIKM7VogGnZrPiUvWgQ8GM8AiMRLizCSQWl0/edit?usp=sharing)

## Collaborative Project Documentation links

###### Project Requirements Google Doc link:
[Project Requirements link](https://docs.google.com/document/d/1jK5SMebc2KZXrWDSEhD-Uoqr7eXiCwLy30pSULupH8M/edit?usp=sharing)
Note: the first edit you should do is the include your name on the copyright page.

###### Project UML diagrams.net link:
[Diagrams.net link](https://drive.google.com/file/d/1ZrRywBNkzC5qNdocyuXb9DE71RfPt1kw/view?usp=sharing)

## Project Proposal

Finding a movie to watch can be a dilemma. People looking for entertainment certainly know that interests them, but not necessarily which movies fit the bill.

Someone may be interested in certain movies due to internet buzz or friends' recommendations, but they are unsure if it is something that they enjoy.


I am proposing a movie library tool, similar to the book library tools such as Goodreads.


The system will import a collection of available movies and provide the user the ability to search, sort, collect, review and save information to their personal collections.

Perhaps the user would create different wish lists for different occasions (date night, best sports movies ever) and need to be able to filter through thousands of titles to find candidates they can add to their wish lists.

    - The library tool should be able to find similar movies based on various attributes to recommend to the user while they search.
    - User accounts and lists must be persisted. In other words, a user should not lose their data when they shut down the system and restart it.
    - The system needs a GUI (Graphical User Interface) that allows user to log in, view their collections, create/edit/remove collections, search the movie data in a variety of ways (by people, genres, rated, etc.).
    - The GUI should consider ease of use for the user as an important factor.
    - Data should be displayed neatly organized with appealing layouts and images.
    - The GUI should use intuitive, easy to understand actions and controls, such as buttons, checkboxes, drop down selections and drag-and-drop.
    - The system does not have any audio components.
    - The backend data for this project will be stored in a JSON formatted file.
    - It will include the mentioned fields of interest, as well as several more.
    - The data will include links to images stored either locally or on the internet for display purposes.
    - There needs to be a way for the system to be configured to find/store that file's location for repeated use by the system on launch.

References relative to JSON:

[Wikipedia JSON](https://en.wikipedia.org/wiki/JSON#:~:text=After%20RFC%204627%20had%20been%20available%20as%20its,was%20also%20standardized%20as%20ISO%20%2F%20IEC%2021778%3A2017)

[Official JSON Organization Website](http://www.json.org/)

I will provide 1 or more suitable java libraries for parsing json text, later.


###### Phase 1 - Use Cases and Functional Requirements

- Please refer to the document: Final Project Document Template.docx for the items required during this Requirements phase. You must produce sections 3.0 Use Cases and 4.0 Requirements.
- You must have at least 4 use cases. Diagram them appropriately.
- Include a cover sheet to your document with a summary of your meetings so far. (How many did you have, a one or two sentence recap of the outcomes of each).
- You must capture regular meeting minutes and assigned action items. Please store your meeting minutes and discussions in canvas where I can see and review them in your team's space.

###### Phase 2 - Design

- The Design Documentation format is described in section 5.0 of the Final Project Document Template.docx
- To turn in for this phase of the project you must include section 5.0 of the document along with UML diagrams for the major classes and interactions that are important to your project. These must include UML class diagrams as well as activity/sequence diagrams where appropriate. You do not need to diagram fundamental classes such as common data structures or utilities (for example ArrayList<>).
- Include the CDC cards for your main classes. These can be scanned in. Note that they will be an appendix in the project documentation. They are not ordinarily kept with project documentation.
- The purpose of the design is to identify the classes you need to implement, their internal fields and the methods you invoke on the objects of that class. Please remember the features of good class design:
- Encapsulation - the utilizer of a class should not be overly concerned with the details of how the class implements internals
- Visibility - do not use public attributes except in very rare cases of things like shared constants, etc.
- The other features presented in Chapter 3: clarity, cohesion, consistency
