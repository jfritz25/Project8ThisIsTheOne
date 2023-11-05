# Project_08 - Movie Search App
<span style="font-size: smaller;"><strong>Ashley Steitz and Jacob Fritz worked on this as partners</strong></span>

---
<span style="font-size: smaller;"><strong> Description </strong> </span>
In our efforts to complete Project 07 we implemented an interactive Ui (User Interface) that allows the user to add notes utilizing Firebase's Realtime Database.

This app allows for a user to:
- Search for a movie
- See the stats (rating, ranking, runtime, etc)
- Share a link
- Visit the IMDB page via link

To begin we integrated an API call to the IMDB page in order to request information on a Movie. If the request
was valid, we parsed the data from the JSON file and displayed the values in an XML file. Through this process we 
allowed the user to share this data or click the link to take them to the IMDB page.
<br>
<br>



## Functionality
'*' indicates tested in GIF  
The following **required** functionality is completed:
<br>
Safeargs and View Groups were implemented to transfer data from MainActivity.kt to Fragment1.kt. This allows us to gather the user data and translate it in real time!

**Demonstrated**
<br>
**START**
* [Add Note] -> [TITLE:Gettysburg address intro]
  [Typed: Four score and seven years ago our fathers brought forth on this continent a new nation] [SAVE]
* [Add Note] -> [TITLE:Lyrics to One Direction's That's what makes you beautiful] [Typed:You're insecure, don't know what for You're turning heads when you walk through the door] [BACK]
* [Add Note] -> [TITLE:Cities I have visited] [Typed: I have been to New York, I have been to Seattle, I have been to Chicago, I have been to Paris, I have been to Madrid] [SAVE]
* [Delete Note] -> [Clicked the second cities I have visitied] -> [Are you sure? Yes/No] -> [Yes]
* [Add Note] -> [TITLE:Animals you see at the Zoo]  [Typed: When i went to the zoo recently. When I I went I saw many animals. I saw lions, i saw elephants, i saw monkeys, i saw orangatans, i saw snakes, and so many more!] [SAVE] [SAVE]

<br>

**END**


---
## Video Walkthrough
Watch a demonstration of the different options when working with the notes app in the gif available on Github
Here's a walkthrough of a few translations:
<br>
[Recording in GIF of Walk Through](https://drive.google.com/drive/folders/1wdu8D1Y70XMGGYCYbNLjWmpL0lUME4LM)

GIF created with [CloudConvert](https://cloudconvert.com/).

UI Challenges:
- Connecting the link as clickable and passing the data in from the JSON file and handling correctly
- UI was relatively simple so not many errors followed

Backend Challenges:
- Calling the API point
- Working with the format through indexing was more of a learning curve but easy once we got it down

## License

    Copyright [2023] [Ashley Steitz, Jacob Fritz]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.