# Pre Work - *Simple To Do App*

**EasyWrite** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: **Ugonna Akali**

Time spent: **4.5** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **view a list of todo items**
* [x] User can **successfully add and remove items** from the todo list
* [x] User's **list of items persisted** upon modification and and retrieved properly on app restart

The following **optional** features are implemented:

* [ ] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/Infinity-108/SimpleToDo/blob/master/SimpleTodo_3.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

While building this app, I encountered an issue while creating the saveData function. When calling FileUtils.writeLines, my writelines 
was highlighted in red which caused my app not to work. I then came to a realization that this was occuring because the implementation that 
I added in the gradle was not synced properly.
I also had an issue where multiple lines of my code was highlighted in red. I realized that this was due to an extra } bracket within my code that messed up
the former layout.

## License

    Copyright [2022] [Ugonna Akali]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
