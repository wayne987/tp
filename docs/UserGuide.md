---
layout: page
title: User Guide
---

AddressBook Level 3 (AB3) is a **desktop app for managing contacts, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, AB3 can get your contact management tasks done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `addressbook.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts.

   * **`add`**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the Address Book.

   * **`delete`**`3` : Deletes the 3rd contact shown in the current list.

   * **`clear`** : Deletes all contacts.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.
  e.g. in `add f/FOOD`, `FOOD` is a parameter which can be used as add `f/Laksa`.

</div>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a calorie intake : `calorie /in`
Add calorie input to the calorie tracker.

Format: `calorie in t/TIME f/FOOD c/CALORIE COUNT`

Examples:  
`calorie /in t/1200 f/Laksa c/290`  
`calorie /in t/1800 f/Drumstick c/76`

### Adding a calorie output : `calorie /out`
Add calorie output to the calorie tracker.

Format: `calorie out t/TIME d/DURATION (MINUTES) c/CALORIE_BURNT`

Examples:  
`calorie /out t/1200 d/60 c/500`  
`calorie /out t/1800 d/30 c/250`


### Listing past entries: `view`
Shows a list of all entries including calorie input, calorie output and daily weight.

Format: `view`

### Deleting an input : `delete /in`
Deletes the calorie input at the specified index.  
The index refers to the index number shown in the calorie input list.  

Format: `delete /in i/INDEX`

Examples:  
`delete /in 2`

### Deleting an output : `delete /out`
Deletes the calorie output at the specified index.
The index refers to the index number shown in the displayed calorie output list.

Format: `delete /out i/INDEX`

Examples:  
`delete /out 2`


### Exiting the program : `exit`
Exits the program.

Format: `exit`


### Saving the data

My Fitness Buddy data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.


--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List** | `list`
**Help** | `help`
