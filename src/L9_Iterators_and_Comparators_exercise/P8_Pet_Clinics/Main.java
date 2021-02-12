package L9_Iterators_and_Comparators_exercise.P8_Pet_Clinics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());

        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        for (int i = 0; i < commandsCount; i++) {
            String[] token = scanner.nextLine().split("\\s+");

            switch (token[0]) {
                case "Create":
                    if (token[1].equals("Pet")) {
                        String petName = token[2];
                        Pet pet = new Pet(petName, Integer.parseInt(token[3]), token[4]);
                        pets.putIfAbsent(petName,pet);
                    } else {
                        try {
                            String clinicName = token[2];
                            Clinic clinic = new Clinic(clinicName, Integer.parseInt(token[3]));
                            clinics.putIfAbsent(clinicName, clinic);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    String petName = token[1];
                    String clinicName = token[2];
                    Pet pet = pets.get(petName);
                    Clinic clinic = clinics.get(clinicName);

                    System.out.println(clinic.addPet(pet));

                    break;
                case "Release":
                    Clinic c = clinics.get(token[1]);
                    System.out.println(c.release());

                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(token[1]).hasEmptyRoom());

                    break;
                case "Print":
                    String klinikName = token[1];
                    Clinic klinik = clinics.get(klinikName);
                    if (token.length == 2) {
                        for (Pet p : klinik.getPets()) {
                            if (p == null) {
                                System.out.println("Room empty");
                            } else {
                                System.out.println(p.toString());
                            }
                        }
                    } else {
                        int room = Integer.parseInt(token[2]);
                        klinik.prinitClinicRoomInfo(room);
                    }

                    break;
            }
        }
    }
}
