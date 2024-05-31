## Description

* I wasted time on a REST service that ended up not working
 
The best one I can find within the time was holidayapi.com. It does cost for a current key to us the current year so my 
free key can only use previous years. I would have externalized everything cleaner but ran out of time

I did only implement one method whic is isDateAHoliday in which you pass in a date. To test isTodayAHoliday has issues 
because this would need to be smart enough to toggle the expected result when actually running on a holiday, most 
likely it would be automated as well but that can't have a static unit test for it as its dynamic. Of course there is a 
way to implement this logic if I had more time. This is representative of what my code would look like committed to a 
master branch but its what I can get done now 
 
I didn't get to implement checking dates such as Martin Luther King Jr. Day, i.e. the 3rd Monday in Jan but I diverted 
to write this README instead 