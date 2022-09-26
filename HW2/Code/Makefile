merge:
		@echo "Running app..."
		javac Merge.java; java Merge ./data/Kickstarter1.csv ./data/Kickstarter2.csv ./data/Kickstarter3.csv
		# javac Merge.java; java Merge ./data/test1 ./data/test2 ./data/test3

search:
		@echo "searching string..."
		javac Search.java; java Search ./data/mergedFile.csv $(inputSearch)

history:
		@echo "history of user input..."
		javac History.java; java History $(inputSearch)

clean:
		@echo "Cleaning up..."
		rm ./*.class
		rm ./.history