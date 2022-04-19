# LinearProgressbar
An App Inventor extension that indicates the progress of an operation using an animated linear bar.

**:date: Release date:** 2022-04-19 12:30:00 (Asia/Hong_Kong)

**:clock12: Version:** 1

**:package: Package name:** com.gordonlu.linearprogressbar

**:hammer_and_wrench: Built with:** Niotron IDE

Some things to note:

- the Theme of Screen1 must **not** be Classic.

- you cannot use a linear progress bar ID that you have previously used in the same screen.

**:open_book: Documentation**

***Event blocks***

>
>**ProgressChanged**
>
>![image](https://user-images.githubusercontent.com/88015331/163945530-90b760e7-8adc-472a-a702-3d5e5222c086.png)
>
>This event is fired when the progress of a linear progress bar has changed. The progress parameter returns the current progress value. If you have enabled Inderterminate for this progress bar, 'progress' will be 0.
>
>*Parameters:* container = component, id = number (int), progress = number (int)

***Method blocks***

>
>**CreateLinearProgressbar**
>
>![image](https://user-images.githubusercontent.com/88015331/163945547-df4fd270-24cc-49f1-91a8-c37b159c6291.png)
>
>Creates a linear progress bar in the given container. If indeterminate is true, an infinite loading animation will be shown on the progress bar. 
>
>*Parameters:* container = component, id = number (int), color = color, indeterminate = boolean

>
>**GetMaximum**
>
>![image](https://user-images.githubusercontent.com/88015331/163945568-e0192916-9d1e-4ce2-afd7-579ef75fceb7.png)
>
>Returns the upper range of the progress bar.
>
>*Returns:* number (int)
>
>*Parameters:* container = component, id = number (int)

>
>**GetMinimum**
>
>![image](https://user-images.githubusercontent.com/88015331/163945585-e6d8d658-29f2-4a1d-95f8-11cb0d23ca7b.png)
>
>Returns the lower range of the progress bar. Only works in devices with Android >= 8.
>
>*Returns:* number (int)
>
>*Parameters:* container = component, id = number (int)

>
>**GetProgress**
>
>![image](https://user-images.githubusercontent.com/88015331/163945639-3a5bfaf6-6788-4a15-922b-523195eba520.png)
>
>Get the progress bar's current level of progress. Return 0 when the progress bar is in indeterminate mode.
>
>*Returns:* number (int)
>
>*Parameters:* container = component, id = number (int)

>
>**IncrementProgressBy**
>
>![image](https://user-images.githubusercontent.com/88015331/163945622-7192dfc0-ceee-4dc7-af14-679a92d0a297.png)
>
>Increases the progress bar's progress by the specified amount.
>
>*Parameters:* container = component, id = number (int), value = number (int)

>
>**SetIndeterminate**
>
>![image](https://user-images.githubusercontent.com/88015331/163945686-f9c720b7-6b5b-4947-b209-61ea5e4b1ccd.png)
>
>Change the indeterminate mode for this progress bar. In indeterminate mode, the progress is ignored and the progress bar shows an infinite animation instead.
>
>*Parameters:* container = component, id = number (int), indeterminate = boolean

>
>**SetIndeterminateColor**
>
>![image](https://user-images.githubusercontent.com/88015331/163945694-d25e7a98-66e1-4b1d-b6fd-c6acb07f1424.png)
>
>Changes the indeterminate color of the progress bar.
>
>*Parameters:* container = component, id = number (int), color = color

>
>**SetMaximum**
>
>![image](https://user-images.githubusercontent.com/88015331/163945708-041279d2-6519-4810-9ae0-5b981342b3d4.png)
>
>Sets the upper range of the progress bar.
>
>*Parameters:* container = component, id = number (int), max = number (int)

>
>**SetMinimum**
>
>![image](https://user-images.githubusercontent.com/88015331/163945724-55c19db5-f0d9-4bf8-ab57-2cad5f3cb7dc.png)
>
>Sets the lower range of the progress bar. Only works in devices with Android >= 8.
>
>*Parameters:* container = component, id = number (int), min = number (int)

>
>**SetProgress**
>
>![image](https://user-images.githubusercontent.com/88015331/163945757-a564d778-56e1-4313-b867-252ffa890e52.png)
>
>Sets the current progress to the specified value. Does not do anything if the progress bar is in indeterminate mode.
>
>*Parameters:* container = component, id = number (int), progress = number (int)

>
>**SetProgressColor**
>
>![image](https://user-images.githubusercontent.com/88015331/163945767-384cd2d0-d5ab-4271-86ea-ce435ec552d2.png)
>
>Changes the progress color of the progress bar.
>
>*Parameters:* container = component, id = number (int), color = color

<hr>

:books: FAQ

**Q1**: What is the difference between progress color and indeterminate color?

**A1**: You set the color of the progress bar with SetIndeterminateColor if your progress bar is indeterminate. Else use SetProgressColor.

<hr>

**Q2**: What is a container?

**A2**: A container is used to contain your progress bar. The height and the width of the progress bar will be adjusted to the dimensions of the container. The container should only contain the progress bar, as if you put other components in the container, the progress bar will overlap them.

The container can be a horizontal or vertical arrangement, but not a scroll arrangement.

<hr>
