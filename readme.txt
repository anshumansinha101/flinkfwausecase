Instruction to run the command

There are two files which are broadcasted, which means these has be available in the local of each task manager.
This is because of smaller size of these files.

home/anshuman/alarmed_cust.txt
/home/anshuman/lost_cards.txt

Change the location of these files present in the local and run maven command
> mvn clean install

Running the Bank Server
>nc -lp 9090 < bank_data.txt

Running the Flink Job (Ensure the Flink cluster is up and running)
>./bin/flink run $PROJECT_PATH/BankFraudDetection/target/flink-fwa-0.0.1-SNAPSHOT-jar-with-dependencies.jar

See the output
> tail -f flagged_transaction
