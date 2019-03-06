package lekce6;

import java.util.List;

public class MovieKeeper {
	
	String pathToFolder;

	public MovieKeeper(String pathToFolder) {
		super();
		this.pathToFolder = pathToFolder;
	}
	
	public void runMovieKeeper() {
		introduceMovieKeeper();
		List<String> allTxtFilesList = FilesFinder.searchForTXTFilesInFolder(this.pathToFolder);
		if(allTxtFilesList.isEmpty()) {
			administrateEmptyFolder();
		}else {
			administrateNONemptyFolder(allTxtFilesList);
		}
	}

	private void introduceMovieKeeper() {
		System.out.println("\nMOVIE KEEPER. Pracujem v adresari "+this.pathToFolder+"\n");
	}

	private void administrateEmptyFolder() {
		informAboutEmptyFolder();
		String usersChoice = Input.getStringAnswerFromTheUser();
		if(userWishesNew(usersChoice)) {
			createNewFile();
			runMovieKeeper();;
		}else if(userWishesEnd(usersChoice)) {
			informAboutEnd();
		}else {
			requestValidAnswer();
			runMovieKeeper();
		}
	}
	
	private void administrateNONemptyFolder(List<String> allTxtFilesList) {
		informUserAboutFolderContent(allTxtFilesList);
		String usersChoice = askNextStepsForFolder();
		if(userWishesNew(usersChoice)) {
			createNewFile();
			runMovieKeeper();
		}else if(userWishesEnd(usersChoice)) {
			informAboutEnd();
		}else {
			administrateOpenFile(allTxtFilesList, usersChoice);
		}
	}

	private void administrateOpenFile(List<String> allTxtFilesList, String usersChoice) {
		try {
			String fileToOpen = openWishedFile(allTxtFilesList, usersChoice);
			List<String> fileContent = Reader.readByScanner(fileToOpen);
			if(fileContent.isEmpty()) {
				administrateEmptyFile(usersChoice, fileToOpen, fileContent);
			}else {
				administrateNONemptyFile(usersChoice, fileToOpen, fileContent);
			}
		}catch(NumberFormatException e) {
			requestValidAnswer();
			runMovieKeeper();
		}catch(IndexOutOfBoundsException e) {
			requestValidAnswer();
			runMovieKeeper();
		}
	}

	private void administrateEmptyFile(String usersChoice, String fileToOpen, List<String> fileContent) {
		informAboutEmptyFile(usersChoice);
		displayChoiceForEmptyFile(fileToOpen, fileContent);
		runMovieKeeper();
	}

	private void administrateNONemptyFile(String usersChoice, String fileToOpen, List<String> fileContent) {
		informAboutFileContent(usersChoice);
		Reader.printOutputFromReader(fileContent);
		displayChoiceForNONEmptyFile(fileToOpen, fileContent);
		runMovieKeeper();
	}

	private void informAboutEmptyFolder() {
		System.out.println("V adresari nie sú žiadne textové súbory MovieKeeperu. Zadajte \"N\" pre \"Novy\" alebo \"K\" pre \"Konec\".");
	}
	
	private boolean userWishesNew(String usersChoice) {
		return usersChoice.equals("N");
	}

	private void createNewFile() {
		System.out.println("Zadajte názov Vašeho nového súboru: ");
		String newFileNameFromUser = Input.getStringAnswerFromTheUser();
		String pathToFile = createPathToNewFile(newFileNameFromUser);
		Writer.writeToNewFile(pathToFile, "");
	}
	
	private boolean userWishesEnd(String usersChoice) {
		return usersChoice.equals("K");
	}
	
	private void informAboutEnd() {
		System.out.println("Koncime.");
	}
	
	private void requestValidAnswer() {
		System.out.println("Zadajte platnú odpoved.");
	}

	private void informUserAboutFolderContent(List<String> allTxtFilesList) {
		System.out.println("V adresari máte tieto textové súbory MovieKeeperu: ");
		FilesFinder.printOutAllTXTFiles(allTxtFilesList);
	}
	
	private String askNextStepsForFolder() {
		System.out.println("Zadajte císlo suboru, ktorého obsah chcete nacítat, \"N\" pre novy subor alebo \"K\" pre \"Konec\".");
		String usersFileNumber = Input.getStringAnswerFromTheUser();
		return usersFileNumber;
	}
	
	private void informAboutEmptyFile(String usersFileNumber) {
		System.out.println("V subore "+usersFileNumber+" nemate zaznamenane ziadne filmy.");
	}
	
	private void writeNewMovieInTheFile(String fileToOpen) {
		System.out.println("Zadajte názov filmu, ktory chcete zapisat: ");
		String usersNewMovie = Input.getStringAnswerFromTheUser();
		Writer.writeToExistingFile(fileToOpen, usersNewMovie);
	}
	
	private String createPathToNewFile(String newFileNameFromUser) {
		String pathToFile = this.pathToFolder+"\\"+newFileNameFromUser+".txt";
		return pathToFile;
	}
	
	private String openWishedFile(List<String> allTxtFilesList, String usersChoice) {
		Integer fileNumber = Integer.parseInt(usersChoice);
		String fileToOpen = allTxtFilesList.get(fileNumber-1);
		return fileToOpen;
	}
	
	private void displayChoiceForEmptyFile(String fileToOpen, List<String> fileContent) {
		while (true) {
			System.out.println("Zadajte \"N\" pre \"Novy film\" alebo \"K\" pre \"Konec\".");
			String usersChoice = Input.getStringAnswerFromTheUser();
			if(userWishesNew(usersChoice)) {
				writeNewMovieInTheFile(fileToOpen);
				displayChoiceForNONEmptyFile(fileToOpen, fileContent);
				break;
			}else if(userWishesEnd(usersChoice)) {
				break;
			}else {
				requestValidAnswer();
				continue;
			}						
		}
	}
	
	private void informAboutFileContent(String usersFileNumber) {
		System.out.println("V subore "+usersFileNumber+" mate zaznamenane tieto filmy: ");
	}
	
	private void displayChoiceForNONEmptyFile(String fileToOpen, List<String> fileContent) {
		while (true) {
			System.out.println("Zadajte \"N\" pre \"Novy film\", \"V\" pre \"Vymzat film\" alebo \"K\" pre \"Konec\".");
			String usersChoice = Input.getStringAnswerFromTheUser();
			if(userWishesNew(usersChoice)) {
				writeNewMovieInTheFile(fileToOpen);
				continue;
			}else if(userWishesEnd(usersChoice)) {
				break;
			}else if(usersChoice.equals("V")) {
				System.out.println("Zadajte názov filmu, ktory chcete vymazat: ");
				String usersDeleteMovie = Input.getStringAnswerFromTheUser();
				Reader.deleteTextFromFile(fileContent, usersDeleteMovie, fileToOpen);
			}else {
				requestValidAnswer();
				continue;
			}
		}
	}
}
