---
layout: page
title: Ng Jia Xin's Project Portfolio Page
---

## Project: My Fitness Buddy

My Fitness Buddy is a desktop address book application used for teaching Software Engineering principles. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

* **New Feature**: Added the ability to undo/redo previous commands.
  * What it does: allows the user to undo all previous commands one at a time. Preceding undo commands can be reversed by using the redo command.
  * Justification: This feature improves the product significantly because a user can make mistakes in commands and the app should provide a convenient way to rectify them.
  * Highlights: This enhancement affects existing commands and commands to be added in future. It required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.
  * Credits: *{mention here if you reused any code/ideas from elsewhere or if a third-party library is heavily used in the feature so that a reader can make a more accurate judgement of how much effort went into the feature}*

* **New Feature**: Added the ability to create a new person object.
  * What it does: allows the user to create a new person with an empty records and a profile.
  * Justification: This feature improves the product significantly because a user can now have a unique set of data that belongs to him/her only. 
  * Highlights: This enhancement affects the number of users our product can accommodate, and the ability to display multiple user information on the same interface. The implementation was tedious as it required new methods to check for unique persons.
  * Credits: *{the idea of person class came from Address Book Level 3}*

* **New Feature**: Added the ability to create a new profile.
  * What it does: allows the user to create a new profile that stores the relevant name, unique identity number, height and target weight of a user.
  * Justification: This feature improves the product significantly because a user is now identifiable by the unique identity number and able to store relevant information. 
  * Highlights: This enhancement affects existing commands and commands to be added in the future. The implementation too was challenging as it required new commands to allow users to edit their profile and methods to check for unique person.

* **New Feature**: Added the ability to add calorie input.
  * What it does: allows the user to add a calorie input to the daily record.
  * Justification: This feature improves the product significantly because a user can document the information on calories consumed daily.
  * Highlights: This enhancement affects existing commands and commands to be added in future. It required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.

* **New Feature**: Added a UniquePersonList that allows the user to navigate the list of existing users in the application.
  * What it does: allows multiple persons' profiles to be displayed in the interface so that Commanders can benefit from this product as well.
  * Justification: This feature improves the scope of the product because it enabled another group of target audience to use it.
  * Highlights: This enhancement created more methods to check for unique person before adding more profiles. 

* **Code contributed**: [https://github.com/AY2021S1-CS2103T-W11-3/tp/tree/master]()

* **Project management**:
  * Managed releases `v1.3` - `v1.5rc` (3 releases) on GitHub

* **Enhancements to existing features**:
  * Updated the GUI color scheme (Pull requests [\#33](), [\#34]())
  * Wrote additional tests for existing features to increase coverage from 88% to 92% (Pull requests [\#36](), [\#38]())

* **Documentation**:
  * User Guide:
    * Added documentation for the features `add`, `edit` and `delete` [\#150]()
    * Did cosmetic tweaks to existing documentation of features `create`: [\#117]()
  * Developer Guide:
    * Added implementation details of the `delete` feature. // tbc

* **Community**:
  * PRs reviewed (with non-trivial review comments): [\#12](), [\#32](), [\#19](), [\#42]()
  * Contributed to forum discussions (examples: [1](), [2](), [3](), [4]())
  * Reported bugs and suggestions for other teams in the class (examples: [1](), [2](), [3]())
  * Some parts of the history feature I added was adopted by several other class mates ([1](), [2]()) //

* **Tools**:
  * Integrated a third party library (Natty) to the project ([\#42]())
  * Integrated a new Github plugin (CircleCI) to the team repo

* _{you can add/remove categories in the list above}_
