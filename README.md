# design-patterns-homework_02
Homework assignment is to create application with specifications as those in following lines, which also should contain implementation of some GOF design patterns. 

##Funcitonal requirements
The assignment continues the description of the first homework with certain changes and new items. 

Briefing needs to be done before each dive, to inform divers on the dive plan. During that dive organization algorithm has to be chosen. Selection of algorithm has to be made according to security rate for the dive.&nbsp;It is necessary to organize dive with all three offered algorithms.&nbsp;The security rate of one diving team is obtained by dividing the maximum depth of the team and the difference of absolute level category between the highest and lowest categories of divers in the team incremented by 1.&nbsp;Total security measures dives equals the security measures of its group. 

To dive is selected algorithm which gives the least value of a security measure because it represents the highest level of security.&nbsp;It is necessary for each dive to print calculated safety rate for each algorithm. 

Detailed information about the dives should be presented in tabular form so that every row contains information about a diver and associated dive. 

Diving club is mandatory to inform the divers associated agencies about details of dives (name, license, date and time, depth). It is also necessary to inform the National Diving Association (HRS) about all dives of all divers. It should be assumed that all agencies (and other institutions' which have to be informed about dives/divers) are not known in advance.

At the end of program execution, in tabular form should be displayed: 
- data on divers so that every row contains information about one dive of one diver
- statistics of all dives (total, average depth, a total of divers per category) by agency and by the National Diving Association 

Before executing the program user inputs the seed for the random number generator (min 3 digits), divers file name, dives file name, the name of the class that represents algotirhm_1, algorithm_2 and algorithm_3, and the name of the output file. 
