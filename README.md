# Bookshelf

## Keep track of your favourite books and new books you want to read.

Bookshelf is for **book lovers, book clubs, or for anyone who has an interest in reading.**
Users will be able to keep track books they've read along with a rating and a review on the book. 
They will also be able to add books that they are interested in reading in the future 
along with a brief description about the book. As an avid reader myself, having a uniqiue application
to keep track of my books and also be able to add personal descriptions for them allows me to stay connected to my
personal hobbies and interests. 

User story:
- As a user, I want to be able to add a book to a list of books I have read 
- As a user, I want to add multiple books to a list of books I have read
- As a user, I want to be able to remove a book from the list of books
- As a user, I want to be able to rate the book that I read (on a scale from 1 to 10)
- As a user, I want to be able to write a review on the book that I read
- As a user, I want to be able to add a book to a list of books I want to read
- As a user, I want to be able to write a brief description for the book I want to read
- As a user, I want to be able to select any book from my read or want to read list and view it in more detail
- As a user, I want to be able to save my list of books to file
- As a user, I want to be able to load my list of books from file

# Instructions for Grader

- You can generate the first required action related to adding Xs to a Y by inputting a book title and description 
in the text fields, then pressing the add button
- You can generate the second required action related to removing Xs from a Y by pressing the remove all button
- You can locate my visual component by adding a book and pressing the add button
- You can save the state of my application by pressing the file option on the top menu bar

# Phase 4: Task 2
Wed Apr 12 20:27:03 PDT 2023

Added book: harry potter with description: fantasy book about wizards and witches

Wed Apr 12 20:27:14 PDT 2023

Added book: hunger games with description: dystopian book

# Phase 4: Task 3
If I had more time to work on the project, I would incorporate more abstract classes into my model as I notice that
the Book and NextBook class have very similar methods. Additionally, I would also convert the BooksReadList and
WantToReadList classes into abstract classes as well to prevent code duplication. Moreover, in the BookApp, instead of
having 10 initial bookshelf options for the user, I would reduce it down to a
few core options that would expand into other options. For example, instead of having
option 1 and 2 of adding to different book shelfs, I would have one option of "add a book" and then it would expand
to other options of either adding to a books read shelf and a want to read shelf.