---
layout: page
title: User Guide
---

Welcome to InTrack!

InTrack is a desktop application for Computer Science students to manage their different internship applications.

InTrack allows users to:

* seamlessly search for and update their various internship applications, as well as
* keep track of the relevant timings and deadlines, 

all through a simple and easy-to-use platform!

InTrack is optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User
Interface (GUI). If you're a Computer Science student who can type fast, InTrack can help you manage your
internship applications more efficiently and effectively than traditional GUI apps.

--------------------------------------------------------------------------------------------------------------------

# How to use this guide

First time using InTrack? We highly recommend reading this user guide in order.

Searching for information about specific features? You might find it helpful to navigate to the relevant sections via
the [Table of Contents](#table-of-contents) for more detailed explanations of individual features.

Alternatively, consider looking at the [Command Summary](#command-summary) for a brief outline of all the commands.

--------------------------------------------------------------------------------------------------------------------

# Table of Contents

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

# Quick start

1. Ensure you have Java 11 or above installed in your Computer.

2. Download the latest `InTrack.jar` from [here](https://github.com/AY2223S1-CS2103T-T11-2/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for InTrack.

4. Launch the app by double-clicking the file or by using the command `java -jar InTrack.jar` in your terminal. The GUI
   similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>

   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. E.g. typing **`help`** and pressing Enter will
   open the help window.<br>
   Some example commands you can try:

   * **`help`** : Opens the Help window, which contains a link to this User Guide, as well as a summary of all the
   commands InTrack provides.

   * **`list`** : Lists all internship applications.

   * **`add`**`c/Microsoft p/Software Engineer s/5000 e/hr@microsoft.com w/careers.microsoft.com t/Urgent` :
     Adds an internship application for `Software Engineer` at `Microsoft` to InTrack.

   * **`delete`**`1` : Deletes the first internship application displayed in InTrack.

   * **`exit`** : Exits InTrack.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

# GUI Summary

The following is an annotated breakdown of InTrack's GUI:

![GUI Summary](images/GUISummary.png)

1. Command window: User inputs commands here.
2. Display window: Relevant messages are displayed here. These can include success messages, error messages, and 
the resulting statistics from when the `stats` command is entered.
3. Internship panel: The list of internship applications in InTrack is displayed here. By default, this panel displays 
the complete list of internships, but this may change when some list management commands such as `filter` or `sort` 
are entered.
4. Individual internship window: By default, this is left blank. When the `select` command is used, the various fields 
of the selected internship will be shown here.

--------------------------------------------------------------------------------------------------------------------

# Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  E.g. in `add p/POSITION`, `POSITION` is a parameter which can be used as `add p/Software Engineer`.

* Items in square brackets are optional.<br>
  E.g `w/WEBSITE [t/TAG]` can be used as `w/careers.microsoft.com t/Urgent` or as `w/careers.microsoft.com`.

* Items with `…` after them can be used multiple times including zero times.<br>
  E.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/Urgent`, `t/Urgent t/Remote` etc.

* If a parameter is expected only once in the command, but is specified multiple times, only the last occurrence of
  the parameter will be taken.<br>
  E.g. if the command specifies `c/Microsoft c/Apple`, it will be interpreted as `c/Apple`.

* Extraneous parameters for commands that do not take in parameters (such as `help` and `list`) will be ignored.<br>
  E.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

## General Features

### Viewing help: `help`

If you're a little stuck, entering this command opens a help window with a link to this user guide, as well as a summary
of all the commands InTrack provides.

Format: `help`

![help message](images/helpMessage.png)

[Back to Table of Contents](#table-of-contents)

### Viewing statistics of internship applications: `stats`

This command displays the statistical breakdown of your current list of internship applications. The statistics are 
calculated based on the number of offered, in-progress and rejected applications.

Format: `stats`

![StatsFeature](images/StatsFeature.png)

[Back to Table of Contents](#table-of-contents)

### Exiting the program: `exit`

If you're done and would like to close InTrack, you can do so by entering the `exit` command.

Format: `exit`

[Back to Table of Contents](#table-of-contents)

### Saving the data

InTrack data is saved in the hard disk automatically after any command that changes the data.
There is no need to save manually.

[Back to Table of Contents](#table-of-contents)

## Internship Application Management

### Adding an internship application: `add`

This command adds a new internship application to InTrack with the parameters you have entered. When you add a new 
internship application, you must specify the company and position name, the relevant email, website and salary, 
and you also have the option to add relevant tags to the entry.

Format: `add c/COMPANY p/POSITION e/EMAIL w/WEBSITE s/SALARY [t/TAG]…`

| Parameter  | Representation                               | Constraints                                                                   |
|------------|----------------------------------------------|-------------------------------------------------------------------------------|
| `COMPANY`  | Company that is offering the internship      | Must contain only alphanumeric characters and spaces, and should not be blank |
| `POSITION` | Position of the internship                   | Must not be blank                                                             |
| `EMAIL`    | Email of the hiring team                     | Must be of the format `local-part@domain`                                     |
| `WEBSITE`  | Website containing details of the internship | Must be a valid URL                                                           |
| `SALARY `  | Salary of the position                       | Must contain only numbers                                                     |
| `TAG`      | Tag(s) of the internship application         | Must be one word per tag and contain only alphanumeric characters             |

<div markdown="span" class="alert alert-primary">
:bulb: **Tip:** An internship can have any number of tags (including 0), and you can add multiple tags at once.
</div>

<div markdown="block" class="alert alert-info">

**:information_source: Note about duplicates:**<br>

An internship application can only be added if it does not currently exist in InTrack. Each internship application is
uniquely identified by its `COMPANY` and `POSITION` with no regards to case-sensitivity.<br>

Example: If an internship application with the parameters `c/Microsoft p/Software Engineer` already exists in InTrack,
a new one with `c/MICROSOFT p/Software Engineer` will be treated as a duplicate and will not be added.

</div>

<div markdown="block" class="alert alert-info">

**:information_source: Note regarding status:**<br>

By default, an added internship will have the status of in-progress. To update this, you can make use of the
[`status` command](#updating-status-of-an-internship-application--status).

</div>

Examples of usage:

* `add c/Microsoft p/Software Engineer e/hr@microsoft.com w/https://careers.microsoft.com s/5000 t/Urgent`

* `add c/Apple p/Frontend Developer e/hr@apple.com w/https://www.apple.com/careers s/5000`

Expected outcome:

* Internship application with the given information is added to InTrack and appears at the bottom of the displayed list.

[Back to Table of Contents](#table-of-contents)

### Deleting an internship application: `delete`

Deletes the internship application at the specified `INDEX` from InTrack.

Format: `delete INDEX`

| Parameter | Representation                                 | Constraints                                                                                    |
|-----------|------------------------------------------------|------------------------------------------------------------------------------------------------|
| `INDEX`   | The index of the target internship application | Must be a positive unsigned integer and must not exceed the size of the current displayed list |

Example of usage:

* `delete 1`

Expected outcome:

* The first internship application in InTrack is deleted.

Before deleting the internship application for `Software Engineer` at `Microsoft` at `INDEX` 1:

![Ui](images/Ui.png)

After deleting the internship application for `Software Engineer` at `Microsoft` previously at `INDEX` 1:

![DeleteFeature](images/DeleteFeature.png)

[Back to Table of Contents](#table-of-contents)

### Updating status of an internship application : `status`

Updates the status of the internship application at the specified `INDEX` in InTrack with 1 of 3 possible statuses:
`o` for `Offered`, `p` for `Progress` or `r` for `Rejected`.

Format: `status INDEX STATUS`

| Parameter | Representation                                 | Constraints                                                                                    |
|-----------|------------------------------------------------|------------------------------------------------------------------------------------------------|
| `INDEX`   | The index of the target internship application | Must be a positive unsigned integer and must not exceed the size of the current displayed list |
| `STATUS`  | The new status of the internship application   | Must be either `o`, `p`, `r` or their capitalised forms                                        |

Example of usage:

* `status 1 o`

Expected outcome:

* The status of the first internship application in InTrack is updated to `Offered`.

Before updating the status of the internship application at `INDEX` 1 to `Offered`:

![Ui](images/Ui.png)

After updating the status of the internship application at `INDEX` 1 to `Offered`:

![StatusFeature](images/StatusFeature.png)

[Back to Table of Contents](#table-of-contents)

### Adding a tag to an internship application : `addtag`

Adds one or more `Tag`s to the internship application at the specified `INDEX` in InTrack.

Format: `addtag INDEX TAG [MORE_TAGS]...`

| Parameter | Representation                                    | Constraints                                                                                    |
|-----------|---------------------------------------------------|------------------------------------------------------------------------------------------------|
| `INDEX`   | The index of the target internship application    | Must be a positive unsigned integer and must not exceed the size of the current displayed list |
| `TAG`     | The tag to be added to the internship application | Must be one word per tag and contain only alphanumeric characters                              |

<div markdown="block" class="alert alert-info">

**:information_source: Note about `addtag`:**<br>

`TAG` is case-sensitive, so `urgent` and `Urgent` are considered as separate tags. If a tag already exists in an
internship application, duplicates of it will not be added.

If multiple `TAG`s are specified in an `addtag` command, duplicate `TAG`s will not be added while non-duplicate ones
will be added as per normal.

</div>

Example of usage:

* `addtag 1 Urgent`

Expected outcome:

* The `Urgent` tag will appear on the first internship application in InTrack.

[Back to Table of Contents](#table-of-contents)

### Deleting a tag from an internship application : `deltag`

Deletes one or more existing `Tag`s from the internship application at the specified `INDEX` in InTrack.

Format: `deltag INDEX TAG [MORE_TAGS]...`

| Parameter | Representation                                        | Constraints                                                                                    |
|-----------|-------------------------------------------------------|------------------------------------------------------------------------------------------------|
| `INDEX`   | The index of the target internship application        | Must be a positive unsigned integer and must not exceed the size of the current displayed list |
| `TAG`     | The tag to be deleted from the internship application | Must be one word per tag and contain only alphanumeric characters                              |

Example of usage:

* `deltag 1 Urgent`

Expected outcome:

* The `Urgent` tag, if it exists, will be removed from the first internship application in InTrack.

[Back to Table of Contents](#table-of-contents)

### Selecting an internship application : `select`

Selects and shows the details of the internship application at the specified `INDEX`.

<div markdown="block" class="alert alert-info">

**:information_source: Note about `select`:**<br>

An internship application entry must be selected via the `select` command before the `edit`, `addtask`, `deltask`,
`mail` and `remark` commands can be used. This ensures that the user can see the entire internship application 
before executing these commands, which might rely on fields not visible from the list view.

</div>

Format: `select INDEX`

| Parameter | Representation                                        | Constraints                                                                                    |
|-----------|-------------------------------------------------------|------------------------------------------------------------------------------------------------|
| `INDEX`   | The index of the target internship application        | Must be a positive unsigned integer and must not exceed the size of the current displayed list |

Example of usage:

* `select 1`

Expected outcome:

* The first internship application in InTrack is selected and its details are shown on the right panel.

Before selecting the internship application at `INDEX` 1:

![Ui](images/Ui.png)

After selecting the internship application at `INDEX` 1:

![SelectFeature](images/SelectFeature.png)

[Back to Table of Contents](#table-of-contents)

### Editing an internship application : `edit`

Edits the details of the currently selected internship application.

<div markdown="block" class="alert alert-info">

**:information_source: Before using `edit`:**<br>

Before an internship application can be edited, it must first be selected via the
[`select` command](#selecting-an-internship-application--select).

</div>

Format: `edit [c/NEW_COMPANY] [p/NEW_POSITION] [e/NEW_EMAIL] [w/NEW_WEBSITE] [s/NEW_SALARY] [t/NEW_TAG]...`

| Parameter      | Representation                               | Constraints                                                                   |
|----------------|----------------------------------------------|-------------------------------------------------------------------------------|
| `NEW_COMPANY`  | Company that is offering the internship      | Must contain only alphanumeric characters and spaces, and should not be blank |
| `NEW_POSITION` | Position of the internship                   | Must not be blank                                                             |
| `NEW_EMAIL`    | Email of the hiring team                     | Must be of the format `local-part@domain`                                     |
| `NEW_WEBSITE`  | Website containing details of the internship | Must be a valid URL                                                           |
| `NEW_SALARY`   | Salary of the position                       | Must contain only numbers                                                     |
| `NEW_TAG`      | Tag(s) of the internship application         | Must be one word per tag and contain only alphanumeric characters             |

<div markdown="block" class="alert alert-info">

**:information_source: Note about `edit`:**<br>

At least one of the optional fields must be provided.

The status and remark field of an internship application can only be edited via the
[`status` command](#updating-status-of-an-internship-application--status)
and [`remark` command](#adding-a-remark-to-an-internship-application--remark) respectively.

</div>

Examples of usage:

* `edit c/Google p/Data Analyst e/google@gmail.com w/https://google.com t/URGENT s/1000`

Expected outcome:

* Edits the fields of the selected entry to match that in the input, in that the name of the company changes to
  Google, the position changes to Data Analyst, the email changes to google@gmail.com, the website changes to
  https://google.com, the tags are changed to just `URGENT` and the salary changes to $1000.


Examples of usage:

* `edit p/SWE`

Expected outcome:

* Edits the position field of the selected entry to become SWE. All other details of the entry remain unchanged.

[Back to Table of Contents](#table-of-contents)

### Adding a task to a selected internship application : `addtask`

Adds a task to the currently selected internship application.

<div markdown="block" class="alert alert-info">

**:information_source: Before using `addtask`:**<br>

Before a task can be added to an internship application, the internship application must first be selected via the
[`select` command](#selecting-an-internship-application--select).

</div>

Format: `addtask TASK_NAME /at TASK_TIME`

| Parameter   | Representation                      | Constraints                                |
|-------------|-------------------------------------|--------------------------------------------|
| `TASK_NAME` | Name of the task to be added        | Can take any values, but must not be blank |
| `TASK_TIME` | The time that the task is due or at | Must be in the format `dd-MM-yyyy HH:mm`   |

Example of usage:

* `select 1` followed by `addtask Technical Interview /at 12-01-2023 15:00`

Expected outcome:

* The selected internship application is updated with the new task added in its task list.

Before adding a new task for `Technical Interview` at `12-01-2023 15:00` to the selected internship application:

![AddTaskFeatureBefore](images/AddTaskFeatureBefore.png)

After adding a new task for `Technical Interview` at `12-01-2023 15:00` to the selected internship application:

![AddTaskFeatureAfter](images/AddTaskFeatureAfter.png)

[Back to Table of Contents](#table-of-contents)

### Deleting a task from a selected internship application : `deltask`

Deletes the task at the specified `TASK_INDEX` in the task list of the currently selected internship application.

<div markdown="block" class="alert alert-info">

**:information_source: Before using `deltask`:**<br>

Before a task can be deleted from an internship application, the internship must first be selected via the
[`select` command](#selecting-an-internship-application--select).

</div>

Format: `deltask TASK_INDEX`

| Parameter    | Significance                 | Constraints                                                                                         |
|--------------|------------------------------|-----------------------------------------------------------------------------------------------------|
| `TASK_INDEX` | The index of the target task | Must be a positive unsigned integer and must not exceed the size of the current displayed task list |

Examples of usage:

* `deltask 1`

Expected outcome:

* The first task of the selected internship application is deleted.

Before deleting the task at `TASK_INDEX` 1 in the selected internship application:

![AddTaskFeatureBefore](images/AddTaskFeatureBefore.png)

After deleting the task previously at `TASK_INDEX` 1 in the selected internship application:

![DeleteTaskFeatureAfter](images/DeleteTaskFeatureAfter.png)

[Back to Table of Contents](#table-of-contents)

### Adding a remark to an internship application : `remark`

Adds a `remark` to the selected internship application.

<div markdown="block" class="alert alert-info">

**:information_source: Before using `remark`:**<br>

Before a remark can be added to an application or edited, the internship must first be selected via the
[`select` command](#selecting-an-internship-application--select).

</div>

Format: `remark r/[REMARK]`

<div markdown="span" class="alert alert-primary">
:bulb: **Tip:** You can delete the existing remark by leaving the `REMARK` field empty.
</div>

Example of usage:

* `remark r/Revise graphs`

Expected outcome:

* The input remark `Revise graphs` will be added to the remark section of the selected internship application.

Example of usage:

* `remark r/`

Expected outcome:

* The remark section of the selected internship application panel will be cleared.

[Back to Table of Contents](#table-of-contents)

### Sending an email to a company : `mail`

Launches the default mail app and prepares to send an email with the recipient set to the email address
registered to the selected internship.

<div markdown="block" class="alert alert-info">

**:information_source: Before using `mail`:**<br>

Before this command can be used on an internship application, the internship application must first be selected via the
[`select` command](#selecting-an-internship-application--select).

</div>

Format: `mail`

* `mail` does not check if the email address is valid/correct and is the responsibility of the user.
* `mail` invokes the native desktop application of the default mail app.

[Back to Table of Contents](#table-of-contents)

## List Management

### Listing all internship applications : `list`

Shows a list of all internship applications in InTrack. Commonly used to return to the original list after using a 
`filter` or one of the `find` commands.

Format: `list`

[Back to Table of Contents](#table-of-contents)

### Clearing all internship applications : `clear`

`clear` deletes all internship applications in InTrack. You may wish to use this to remove all the sample data in InTrack.

<div markdown="block" class="alert alert-warning">
:warning: `clear` CANNOT BE REVERSED OR UNDONE! Be sure that you wish to remove all existing data before entering the
command.
</div>

Format: `clear`

[Back to Table of Contents](#table-of-contents)

### Finding internship applications by company name : `findc`

Finds internship applications with company names containing any of the given keywords.

Format: `findc KEYWORD [MORE_KEYWORDS]...`

* The search is case-insensitive. E.g. `google` will match `Google`.
* The order of keywords does not matter. E.g. `Bytedance Tiktok` will match `Tiktok Bytedance`.
* Only full words will be matched. E.g. `Goog` will not match `Google`.
* Internship applications with company name matching at least one keyword will be returned. E.g. `findc google tech`
will match `Google` and `Gov tech`.

Example of usage:
* `findc Google`

Expected outcome:
* All internships containing `Google` in the name field (case-insensitive) will be filtered and displayed.

Before using `findc` with the keywords `Microsoft Alphabet`:

![Ui](images/Ui.png)

After using `findc` with the keywords `Microsoft Alphabet`:

![FindcFeature](images/FindcFeature.png)

[Back to Table of Contents](#table-of-contents)

### Finding internship applications by position : `findp`

Finds internship applications with position names containing any of the given keywords.

Format: `findp KEYWORD [MORE_KEYWORDS]...`

* The search is case-insensitive. E.g. `developer` will match `Developer`.
* The order of keywords does not matter. E.g. `Developer Frontend` will match `Frontend Developer`.
* Only full words will be matched. E.g. `Develop` will not match `Developer`.
* Internship applications with position name matching at least one keyword will be returned. E.g. `findp analyst
junior` will match `Data analyst` and `Junior SWE`.

Example of usage:
* `findp Frontend`

Expected outcome:
* All internships containing `Frontend` in the position field (case-insensitive) will be filtered and displayed.

[Back to Table of Contents](#table-of-contents)

### Finding internship applications by tags : `findt`

Finds internship applications which has tags containing any of the given keywords.

Format: `findt KEYWORD [MORE_KEYWORDS]...`

* The search is case-sensitive. E.g. `urgent` will not match `Urgent`.
* The order of keywords does not matter. E.g. `Urgent Remote` will match `Remote Urgent`.
* Only full words will be matched. E.g. `Remote` will not match `Remotely`.
* Internship applications with tags matching at least one keyword will be returned. E.g. `findt urgent remote` will
match tags `urgent` and `remote`.

Example of usage:
* `findt urgent`

Expected outcome:
* All internships with the `urgent` tag (case-insensitive) will be filtered and displayed.

[Back to Table of Contents](#table-of-contents)

### Filtering internship applications by status : `filter`

Filters all internship applications based on their status, using `p` for "Progress", `r` for "Rejected" and
`o` for "Offered".

Format: `filter STATUS`, where `STATUS` must be either `p`, `o` or `r` or their capitalised counterparts

Example of usage:
* `filter o`

Expected outcome:
* All internship applications that have status "Offered" will be filtered and displayed.

Before filtering by "Offered" status:

![FilterFeatureBefore](images/FilterFeatureBefore.png)

After filtering by "Offered" status:

![FilterFeatureAfter](images/FilterFeatureAfter.png)

[Back to Table of Contents](#table-of-contents)

### Sorting internship applications: `sort`

Sorts the current list of internship applications on the left panel via their `SORT_TYPE` which is either `time` or `salary`,
in either ascending or descending `SORT_ORDER`.

Format: `sort SORT_TYPE SORT_ORDER`

<div markdown="block" class="alert alert-info">

**:information_source: Note about `SORT`:**<br>
For sorting by the time of their tasks, internships are sorted with the current date and time taken
into consideration.

Internships are sorted by their earliest **upcoming tasks as per the current date and time**, thus tasks whose dates 
are before the current date are **not taken into account** when sorting is conducted.

This means that internships without any upcoming tasks (i.e. internships without any tasks or with all tasks that are past the current date), will not
be sorted in any particular order and will be kept at the bottom of the list of internships instead no matter what SORT_ORDER is given.

</div>

| Parameter    | Representation                                   | Constraints                                                                                    |
|--------------|--------------------------------------------------|------------------------------------------------------------------------------------------------|
| `SORT_TYPE`  | The attribute that the internships are sorted by | Is case-insensitive and can only take `time` and `salary` as input fields, and cannot be blank |
| `SORT_ORDER` | The order that the internships are sorted in     | Is case-insensitive and can only take `a` and `d` as input fields, and cannot be blank         |

Example of usage:

* `sort time a`

Expected outcome:

* The list of internships are sorted in an ascending manner, with the internship with the task with the earliest date 
and time that is after the current date and time at the top.

Example of usage:

* `sort salary a`

Expected outcome:

* The list of internships are sorted in an ascending manner, with the internship with the lowest salary at the top.

Before sorting by upcoming task time in ascending order:

![Ui](images/Ui.png)

After sorting by upcoming task time in ascending order:

![SortFeature](images/SortFeature.png)

[Back to Table of Contents](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

# FAQ

**Q**: What is a positive unsigned integer?<br>
**A**: A positive unsigned integer is a whole number that ranges from 1 to 4294967295 inclusive.

--------------------------------------------------------------------------------------------------------------------

# Command summary

## General Features

| Action              | Format  |
|---------------------|---------|
| **View help**       | `help`  |
| **View statistics** | `stats` |
| **Exit InTrack**    | `exit`  |

## Internship Application Management

| Action                                      | Format, Examples                                                                                                                                                                                                                                    |
|---------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add internship application**              | `add c/COMPANY p/POSITION e/EMAIL w/WEBSITE s/SALARY [t/TAG]… ` <br/> e.g. `add c/Microsoft p/Software Engineer e/hr@microsoft.com w/https://careers.microsoft.com s/5000 t/Urgent`                                                                 |
| **Delete internship application**           | `delete INDEX` <br/> e.g. `delete 1`                                                                                                                                                                                                                |
| **Update status of internship application** | `status INDEX STATUS`<br/> e.g. `status 1 o`                                                                                                                                                                                                        |
| **Add tag to internship application**       | `addtag INDEX TAG [MORE_TAGS]...`<br/> e.g. `addtag 1 Urgent`                                                                                                                                                                                       |
| **Delete tag from internship application**  | `deltag INDEX TAG [MORE_TAGS]...`<br/> e.g. `deltag 1 Urgent`                                                                                                                                                                                       |
| **Select internship application**           | `select INDEX` <br/> e.g. `select 1`                                                                                                                                                                                                                |
| **Edit internship application**             | `edit [c/NEW_COMPANY] [p/NEW_POSITION] [e/NEW_EMAIL] [w/NEW_WEBSITE] [s/NEW_SALARY] [t/NEW_TAG]...` <br/> Note: An internship application must be selected first and at least one of the optional fields must be provided. <br/> e.g. `edit s/1200` |
| **Add task to internship application**      | `addtask TASK_NAME /at TASK_TIME ` <br/> Note: An internship application must be selected first. <br/> e.g. `addtask Technical Interview /at 28-10-2022 17:00`                                                                                      |
| **Delete task from internship application** | `deltask TASK_INDEX` <br/> Note: An internship application must be selected first. <br/> e.g. `deltask 1`                                                                                                                                           |
| **Add remark to internship application**    | `remark r/[REMARK]` <br/> Note: An internship application must be selected first. <br/> e.g. `remark r/Revise graphs`                                                                                                                               |
| **Send email to internship application**    | `mail` <br/> Note: An internship application must be selected first.                                                                                                                                                                                |

## List Management

| Action                               | Format, Examples                                              |
|--------------------------------------|---------------------------------------------------------------|
| **List all internship applications** | `list`                                                        |
| **Clear all entries**                | `clear`                                                       |
| **Find by company**                  | `findc KEYWORD [MORE_KEYWORDS]...`<br/> e.g. `findc Google`   |
| **Find by position**                 | `findp KEYWORD [MORE_KEYWORDS]...`<br/> e.g. `findp Frontend` |
| **Find by tag**                      | `findt KEYWORD [MORE_KEYWORDS]...`<br/> e.g. `findt Urgent`   |
| **Filter by status**                 | `filter STATUS` <br/> e.g. `filter o`                         |
| **Sort by time or salary**           | `sort SORT_TYPE SORT_ORDER`<br/> e.g. `sort time a`           |
