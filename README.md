# LabCorpAssessment
LabCorp Java API Automation Coding Assessment
QA Automation Coding Test (2.0 hrs)
For both the tests below, upload the test project(s) on GitHub for review.
Also, ensure the project can be run during the next interview session. Questions will be based on the implementation of the Test Solution(s).
I.	The below test applies for API Test Automation Development positions
Develop a test method in Selenium to browse from www.labcorp.com through the Careers link to a specific LabCorp job listing confirming information on the job posting. Please be sure to accomplish the following tasks:
1.	Start the test by opening a browser to www.labcorp.com 
2.	Find and click Careers link
3.	Search for any position (that is currently active on the site) example “QA Test Automation Developer” 
4.	Select and browse to the position 
5.	Add assertions to confirm
a.	Job Title
b.	Job Location
c.	Job Id 
d.	Any 3 other assertions of your choice (could be text in the requirements / introduction)
Example: (Text in quotes “” from below example should be updated by candidate to match that in the position chosen for the automation solution):

•	Confirm first sentence of third paragraph under Description/Introduction as “The right candidate for this role will participate in the test automation technology development and best practice models.” 
•	Confirm second bullet point under Management Support as “Prepare test plans, budgets, and schedules.” 
•	Confirm third requirement as “5+ years of experience in QA automation development and scripting.” 
•	Confirm first suggested automation tool to be familiar with contains “Selenium” 
6.	Click Apply Now and confirm Job Title, Job Location, Job ID and another text of choice to match the previous page in the proceeding page. 
7.	Click to Return to Job Search
Be sure to include the proper wait methods, at least three different “By” types when searching elements, and that it is tested in Chrome. For the 
For the API Test Automation Developer position
-	The project should be written in Java with BDD implementation 
-	Attempt the Test on Rest API Test Automation in point II below. 
II.	The below test applies to API Test Automation Development position
Automate the below sample API using REST Assured for both POST and GET calls.

For POST use this sample json: https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1//Users
 
{
        "createdAt": 1631825833,
        "employee_firstname": "TestData12345",
        "employee_lastname": "TestData12345",
        "employee_phonenumbe": "264-783-9453",
        "ademployee_emaildress": "ademployee_emaildress 1",
        "citemployee_addressy": "citemployee_addressy 1",
        "stateemployee_dev_level": "stateemployee_dev_level 1",
        "employee_gender": "employee_gender 1",
        "employee_hire_date": "2025-10-31T16:35:45.426Z",
        "employee_onleave": true,
        "tech_stack": [],
        "project": []
    }

After it got posted, get the information calling get service, and verify the record is retried successfully with all the details.
 
https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1//Users

Attempt at least 3 if not more scenarios for above services.
Note: Make sure you have the same json object when sending the request.


![image](https://user-images.githubusercontent.com/115437505/194792585-ec34e445-0b99-4fbb-ad95-70007a2e2495.png)
