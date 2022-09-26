merge:
		@echo "Merging files into 'mergedFile.csv' ..."
		javac Merge.java; java Merge ./data/mergedFile.csv ./data/Kickstarter1.csv ./data/Kickstarter2.csv ./data/Kickstarter3.csv
		# javac Merge.java; java Merge ./data/mergedFile.csv ./data/test1 ./data/test2 ./data/test3

search:
		@echo "Searching String in 'mergedFile.csv'..."
		javac Search.java; java Search ./data/mergedFile.csv $(inputSearch)

history:
		@echo "History of User Input..."
		javac History.java; java History $(inputSearch)

clean:
		@echo "Cleaning Up..."
		rm ./*.class
		rm ./.history