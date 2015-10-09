Create application in Java for the company that enable to read invoice.csv file,
stock.csv and store them into the memory.  Invoice data represent product that 
company receive and store data represent what the company still has in their stock. 
When the company sell the product it is automatically saved into their database
table call sale. Get data from the database table sale and store them into memory too.

Compare each set from the table sale such as: if color, sleeves and quality 
are the same add quantity to quantity. After that compare invoice data with sale data 
and with stock data. If there are any different between those data print out a report 
otherwise print "There is no different between invoice, sale and stock".

OUR BRAKING STEPS:

1) 	Read invoice.csv data from H drive in aaa_school folder, 
 	and store them into the memory. 

2) 	Read stock.csv data from the following website 
 	https://github.com/dsajdl01/JavaPractice/blob/master/shirts_trade/stock.csv, 
  	store them into the memory. 

3) 	Get data from table sale and store them into memory (do not use GROUP BY with 
 	sql query, just SETECT * FROM and table name). “purpose of this exercise is 
 	to test your knowledge and solving problems in Java and not SQL”. 

4) 	Compare invoice data with sale and stock data.

5)	If there are any differences print out appropriate report 
 	if not print out no different.
