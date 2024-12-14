# Java File Merger

## Overview
The **Java File Merger** is a utility program designed to merge all `.java` files within a specified directory (and its subdirectories) into a single file called `temp.java`. This tool simplifies working with large projects by consolidating multiple Java files into one for easier inspection or processing.

## Features

### Key Functionalities
1. **Recursive File Search**  
   - Scans the specified directory and all its subdirectories to locate `.java` files.

2. **Imports Consolidation**  
   - Extracts all `import` statements from the `.java` files and includes them at the top of the `temp.java` file.
   - Ensures that duplicate imports are avoided.

3. **File Content Merging**  
   - Merges the content of all `.java` files while:
     - Excluding `import`, `package`, and `public class` declarations.
     - Retaining the logic, methods, and inner structures of the `.java` files.

4. **Output File**  
   - The merged output is saved in the current working directory as `temp.java`.

## Usage Instructions

### Running the Program
1. Compile the program using any Java compiler (e.g., `javac`):
   ```bash
   javac JavaFileMerger.java
   ```
2. Run the program:
   ```bash
   java JavaFileMerger
   ```
3. When prompted, provide the absolute path to the folder containing `.java` files:
   ```
   Enter the path of the folder: /path/to/java/files
   ```
4. The program processes all `.java` files and generates `temp.java` in the current working directory.

### Example
Given a folder structure:
```
project-folder/
  |- File1.java
  |- File2.java
  |- subfolder/
      |- File3.java
```
After running the program and specifying `project-folder` as the input, `temp.java` will contain:
- Consolidated `import` statements.
- The merged contents of `File1.java`, `File2.java`, and `File3.java`.

## Output File Structure
1. **Imports Section**  
   - All unique `import` statements are added at the top of the `temp.java` file.

2. **Merged Content**  
   - The remaining code from all `.java` files is appended, excluding `import`, `package`, and `public class` declarations.

### Example Output (temp.java):
```java
import java.util.List;
import java.util.ArrayList;

// Merged content of all Java files starts here
void someMethod() {
    // logic from File1.java
}

class AnotherClass {
    // logic from File2.java
}
```

## Notes and Limitations
- **Excludes Specific Lines**: Lines starting with `import`, `package`, or `public class` are excluded to ensure clean merging.
- **File Naming Conflict**: Methods and classes with identical names from different files are not resolved automatically, which may lead to compilation issues.
- **No Duplicate Imports Handling**: The current implementation does not filter duplicate imports (this can be enhanced).
- **Output Location**: The `temp.java` file is created in the folder where the program is executed.

## Future Improvements
1. Automatically detect and resolve naming conflicts between classes or methods.
2. Filter out duplicate `import` statements.
3. Add error handling for invalid folder paths or inaccessible files.
4. Improve logging to provide detailed status updates during execution.
5. Allow custom output file naming.

## Contributing
Contributions are welcome! To improve the project:
1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add some feature"
   ```
4. Push to the branch:
   ```bash
   git push origin feature/your-feature-name
   ```
5. Open a pull request.

## License
This project is open-source and available under the MIT License. Feel free to use, modify, and distribute it.

---

Happy coding! 🚀

