![GoodWatches Logo](https://github.com/jab0073/CS321-Group11/blob/5fbba99f6a03984a138dcdc97a0339b5bc912e1f/Documentation/goodwatches%20logo.png)

# CS321-Group11
- Shawn Burnham

- James Haywood

- Jarred Long

- Justin Bushue

# Table of Contents
- [Project Proposal](https://github.com/jab0073/CS321-Group11#project-proposal)

- [Class/Work Schedules](https://github.com/jab0073/CS321-Group11#classwork-schedules)

- [Collaborative Project Documentation](https://github.com/jab0073/CS321-Group11#collaborative-project-documentation)

    - [Phase 1](https://github.com/jab0073/CS321-Group11/blob/main/README.md#phase-1---use-cases-and-functional-requirements)

    - [Phase 2](https://github.com/jab0073/CS321-Group11/blob/main/README.md#phase-2---design)

    - [Phase 3](https://github.com/jab0073/CS321-Group11/blob/main/README.md#phase-3---implementation)

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

###### References relative to JSON:

[Wikipedia JSON](https://en.wikipedia.org/wiki/JSON#:~:text=After%20RFC%204627%20had%20been%20available%20as%20its,was%20also%20standardized%20as%20ISO%20%2F%20IEC%2021778%3A2017)

[Official JSON Organization Website](http://www.json.org/)

## Class/Work Schedules
[Class/Work Schedules](https://docs.google.com/spreadsheets/d/1Zj6V2qRDIKM7VogGnZrPiUvWgQ8GM8AiMRLizCSQWl0/edit?usp=sharing)

_**Tenative Weekly Meetings: Saturdays @ 1:00 PM**_

# Collaborative Project Documentation

[Final Project Documentation](https://docs.google.com/document/d/1gjTqStX6FBkAt3OKbrzCFy5J3OV_Pv2U2Q-0uU_9xlw/edit?usp=sharing)

## Phase 1 - Use Cases and Functional Requirements
_**Submitted on 02/10/2022 by Justin**_

- Please refer to the document: Final Project Document Template.docx for the items required during this Requirements phase. You must produce sections 3.0 Use Cases and 4.0 Requirements.
- You must have at least 4 use cases. Diagram them appropriately.
- Include a cover sheet to your document with a summary of your meetings so far. (How many did you have, a one or two sentence recap of the outcomes of each).
- You must capture regular meeting minutes and assigned action items. Please store your meeting minutes and discussions in canvas where I can see and review them in your team's space.

###### Project Requirements Google Doc link:
[Project Requirements](https://docs.google.com/document/d/1jK5SMebc2KZXrWDSEhD-Uoqr7eXiCwLy30pSULupH8M/edit?usp=sharing)
- This will be used as the base for the Final Project Documentation.
- The first edit you should do is the include your name on the copyright page.

###### Project UML diagrams.net link:
[Diagrams.net](https://drive.google.com/file/d/1ZrRywBNkzC5qNdocyuXb9DE71RfPt1kw/view?usp=sharing)

## Phase 2 - Design
_**Submitted on 03/05/2022 by James**_

- The Design Documentation format is described in section 5.0 of the Final Project Document Template.docx
- To turn in for this phase of the project you must include section 5.0 of the document along with UML diagrams for the major classes and interactions that are important to your project. These must include UML class diagrams as well as activity/sequence diagrams where appropriate. You do not need to diagram fundamental classes such as common data structures or utilities (for example ArrayList<>).
- Include the CDC cards for your main classes. These can be scanned in. Note that they will be an appendix in the project documentation. They are not ordinarily kept with project documentation.
- The purpose of the design is to identify the classes you need to implement, their internal fields and the methods you invoke on the objects of that class. Please remember the features of good class design:
- Encapsulation - the utilizer of a class should not be overly concerned with the details of how the class implements internals
- Visibility - do not use public attributes except in very rare cases of things like shared constants, etc.
- The other features presented in Chapter 3: clarity, cohesion, consistency

###### CRC Cards link:
[CRC Cards](https://docs.google.com/presentation/d/1GOsnx2NHszYy-sL2_1o1KaVt6TZ-FgG1nOWxgyRE9Bc/edit?usp=sharing)


###### Project Design Google Doc Link:
[Project Design](https://docs.google.com/document/d/10F8aMiHMLQmdriyXlFgvTpuQxof5Ho8EHYjcVTVhb0U/edit?usp=sharing) - This will be appended to the Final Project Documentation.


###### Class Diagram Link:
[Class Diagram](https://drive.google.com/file/d/1asyjjNQfIKeHKEU_L7dTbDRP5gQ68bH7/view?usp=sharing)


###### Sequence Diagram Link:
[Sequence Diagram](https://drive.google.com/file/d/1Pj4RPgoOQPjRVnAHSAXAva-sTQz_6TvE/view?usp=sharing)


## Phase 3 - Implementation


###### Assigned Tasks Link:
[Assigned Tasks](https://docs.google.com/spreadsheets/d/1Edy5DPGPyGy-__11zUdGLXaPj5TFPLLDmdI75xgVwGg/edit?usp=sharing)

This is your software implementation. You will need to turn in
- The software project your system compiles in
- Instructions for building, configuring and executing your code
- A pre-compiled executable version that I can run directly from the command line of java

You must arrange to demo a working version of your software to me sometime during the
week of April 20th. (see below).

Our final is scheduled for April 28. Finals week begins for all
students on April 25th. I need all outstanding work turned in by Friday, April 22rd.
- You will upload a zipped copy of your final project to Canvas no later than April 22rd. You must
also ensure I have a working copy installed at home so it is probably best not to wait until the
last minute. You may also add me to your github or gitlab project for me to clone to my
desktop.

Each team will schedule a session with me to demonstrate their project to me. All members are required to attend. I will reserve 45 minutes for each appointment, although I anticipate these being no more than 30 minutes.

- Each team member should be prepared to discuss the part of the code they worked on the most and answer questions. Make sure you can hit on the main flow of execution for your system.
The grading rubric is below.
- Deliver a prepared powerpoint or pdf presentation of the presentation assignment to canvas before our meeting.
- Each team should select an appointment via the appointment finder on Canvas Calendar.
