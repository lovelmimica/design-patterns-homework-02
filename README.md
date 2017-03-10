# design-patterns-homework-02
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

##Used design patterns
###Factory Method
The pattern is used for creating proliferated diver agencies and for creating alternative algorithms for dive organization. In class diagram, this pattern is market with ***brown***. 
###Prototype 
The pattern is used to deep copy dive objects for purpose of calculating seructiy rate for each organization variant. In class diagram, this pattern is market with ***red***. 
###Singleton
The pattern is used to enforce uniqueness for particular objects of RandomNumberGenerator, DivingClub and AgencyFactorySingletonDecorator. In class diagram, this pattern is market with ***pink***. 
###Composite
The patterns is used for composing dives and tables (which both are composed of same type parts). In class diagram, this pattern is marked with ***gray***. 
###Decorator
The patterns is used for extending the functionality of AgencyFactory in the way that decorated factory (AgencyFactroySingletonDecorator) enforce uniqueness of each agency which it created (in other words, decorated factory creates instance of agency only when is agency first time called, after what agency is stored in application memory and reused). In class diagram, this pattern is marked with ***violet***. 
###Observer
The pattern is used for reporting to institutions about divers and their dives. In class diagram, this pattern is marked with ***green***. 
###Builder
The pattern is used for creating table objects (which are relatively complex and exists in two alternative forms). In class diagram, this pattern is marked with ***orange***. 
###Template Method
The patterns is used for organization of dives according to three offered algorithms. In class diagram, this pattern is marked with ***yellow***.  

##Class Diagram
f
