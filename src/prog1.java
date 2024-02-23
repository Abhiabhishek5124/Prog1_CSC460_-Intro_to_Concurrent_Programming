import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

public class prog1 {

    public static void main(String[] args) throws IOException {

        /////////////////////////////////////////////////////////////////
        // Program 1
        /////////////////////////////////////////////////////////////////

        // Generating random values and summing them up
        Random random = new Random();
        int trueCount = 0;
        Vector<noSynch> vector = new Vector<>();
        for (int i = 0; i < 100; i++) {
            int randomValue = random.nextInt(201) - 100;
            trueCount += randomValue;
            noSynch nosynch = new noSynch(randomValue);
            vector.add(nosynch);
            nosynch.start();
        }

        // Waiting for all threads to finish
        try {
            Iterator<noSynch> iterator = vector.iterator();
            while (iterator.hasNext()) {
                iterator.next().join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing results of Program 1
        System.out.println("Part #1");
        System.out.println();
        System.out.println("Actual count is " + trueCount);
        System.out.println("Unsynchronized count is " + noSynch.getTotal());
        System.out.println();
        System.out.println();

        /////////////////////////////////////////////////////////////////
        // Program 2
        /////////////////////////////////////////////////////////////////

        // Handling input file for Program 2
        System.out.println("Part #2");
        System.out.println();
        // Creating an instance of progState
        progState pState = new progState();
        // Vector to hold Thread objects
        Vector<Thread> V = new Vector<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ;
            System.out.print("Please enter a path to an input file: ");
            String filePath = reader.readLine();
            System.out.println();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                // Reading input file line by line
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(" ");
                    char classType = parts[0].charAt(0);
                    long sleepTime = Long.parseLong(parts[1]);

                    switch (classType) {
                        case 'A':
                            // Creating and starting Aclass thread
                            Aclass aThread = new Aclass(pState, sleepTime);
                            V.add(aThread);
                            aThread.start();
                            break;
                        case 'B':
                            // Creating and starting Bclass thread
                            Bclass bThread = new Bclass(pState, sleepTime);
                            V.add(bThread);
                            bThread.start();
                            break;
                        case 'C':
                            // Creating and starting Cclass thread
                            Cclass cRunnable = new Cclass(pState, sleepTime);
                            Thread cThread = new Thread(cRunnable);
                            V.add(cThread);
                            cThread.start();
                            break;
                        case 'D':
                            // Creating and starting Dclass thread
                            Dclass dRunnable = new Dclass(pState, sleepTime);
                            Thread dThread = new Thread(dRunnable);
                            V.add(dThread);
                            dThread.start();
                            break;
                        // Printing total count
                        case 'P':
                            pState.printTotal();
                            break;
                        default:
                            System.out.println("Invalid input");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        // Joining all threads in Program 2
        Iterator<Thread> iterate = V.iterator();
        while (iterate.hasNext()) {
            Thread thread = iterate.next();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /////////////////////////////////////////////////////////////////
        // Program 3
        /////////////////////////////////////////////////////////////////

        // Handling input file for Program 3
        Vector<myProcess> processVector = new Vector<>();
        System.out.println();
        System.out.println();
        System.out.println("Part #3");
        try {
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please enter a path to an input file: ");
            String filePath1 = reader1.readLine();

            try (BufferedReader br1 = new BufferedReader(new FileReader(filePath1))) {
                int startingValue = Integer.parseInt(br1.readLine());
                myCounter counter = new myCounter(startingValue);

                String line1;
                // Reading sleep times for myProcess objects
                while ((line1 = br1.readLine()) != null) {
                    int sleepTime = Integer.parseInt(line1);
                    myProcess process = new myProcess(counter, sleepTime);
                    processVector.add(process);
                    process.start();
                }

                // Joining all threads in Program 3
                for (myProcess process : processVector) {
                    try {
                        process.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Printing final counter value
                System.out.println("FINAL Counter value is " + counter.getTotal());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
