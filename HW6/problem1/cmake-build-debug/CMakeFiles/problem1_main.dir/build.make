# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /Applications/CLion.app/Contents/bin/cmake/mac/bin/cmake

# The command to remove a file.
RM = /Applications/CLion.app/Contents/bin/cmake/mac/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/mac/Desktop/HW6/problem1

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/mac/Desktop/HW6/problem1/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/problem1_main.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/problem1_main.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/problem1_main.dir/flags.make

CMakeFiles/problem1_main.dir/test.cpp.o: CMakeFiles/problem1_main.dir/flags.make
CMakeFiles/problem1_main.dir/test.cpp.o: ../test.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/mac/Desktop/HW6/problem1/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/problem1_main.dir/test.cpp.o"
	/Library/Developer/CommandLineTools/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/problem1_main.dir/test.cpp.o -c /Users/mac/Desktop/HW6/problem1/test.cpp

CMakeFiles/problem1_main.dir/test.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/problem1_main.dir/test.cpp.i"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/mac/Desktop/HW6/problem1/test.cpp > CMakeFiles/problem1_main.dir/test.cpp.i

CMakeFiles/problem1_main.dir/test.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/problem1_main.dir/test.cpp.s"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/mac/Desktop/HW6/problem1/test.cpp -o CMakeFiles/problem1_main.dir/test.cpp.s

CMakeFiles/problem1_main.dir/ui.cpp.o: CMakeFiles/problem1_main.dir/flags.make
CMakeFiles/problem1_main.dir/ui.cpp.o: ../ui.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/mac/Desktop/HW6/problem1/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/problem1_main.dir/ui.cpp.o"
	/Library/Developer/CommandLineTools/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/problem1_main.dir/ui.cpp.o -c /Users/mac/Desktop/HW6/problem1/ui.cpp

CMakeFiles/problem1_main.dir/ui.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/problem1_main.dir/ui.cpp.i"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/mac/Desktop/HW6/problem1/ui.cpp > CMakeFiles/problem1_main.dir/ui.cpp.i

CMakeFiles/problem1_main.dir/ui.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/problem1_main.dir/ui.cpp.s"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/mac/Desktop/HW6/problem1/ui.cpp -o CMakeFiles/problem1_main.dir/ui.cpp.s

CMakeFiles/problem1_main.dir/admin_ui.cpp.o: CMakeFiles/problem1_main.dir/flags.make
CMakeFiles/problem1_main.dir/admin_ui.cpp.o: ../admin_ui.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/mac/Desktop/HW6/problem1/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building CXX object CMakeFiles/problem1_main.dir/admin_ui.cpp.o"
	/Library/Developer/CommandLineTools/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/problem1_main.dir/admin_ui.cpp.o -c /Users/mac/Desktop/HW6/problem1/admin_ui.cpp

CMakeFiles/problem1_main.dir/admin_ui.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/problem1_main.dir/admin_ui.cpp.i"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/mac/Desktop/HW6/problem1/admin_ui.cpp > CMakeFiles/problem1_main.dir/admin_ui.cpp.i

CMakeFiles/problem1_main.dir/admin_ui.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/problem1_main.dir/admin_ui.cpp.s"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/mac/Desktop/HW6/problem1/admin_ui.cpp -o CMakeFiles/problem1_main.dir/admin_ui.cpp.s

CMakeFiles/problem1_main.dir/client_ui.cpp.o: CMakeFiles/problem1_main.dir/flags.make
CMakeFiles/problem1_main.dir/client_ui.cpp.o: ../client_ui.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/mac/Desktop/HW6/problem1/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Building CXX object CMakeFiles/problem1_main.dir/client_ui.cpp.o"
	/Library/Developer/CommandLineTools/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/problem1_main.dir/client_ui.cpp.o -c /Users/mac/Desktop/HW6/problem1/client_ui.cpp

CMakeFiles/problem1_main.dir/client_ui.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/problem1_main.dir/client_ui.cpp.i"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/mac/Desktop/HW6/problem1/client_ui.cpp > CMakeFiles/problem1_main.dir/client_ui.cpp.i

CMakeFiles/problem1_main.dir/client_ui.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/problem1_main.dir/client_ui.cpp.s"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/mac/Desktop/HW6/problem1/client_ui.cpp -o CMakeFiles/problem1_main.dir/client_ui.cpp.s

CMakeFiles/problem1_main.dir/shopping_db.cpp.o: CMakeFiles/problem1_main.dir/flags.make
CMakeFiles/problem1_main.dir/shopping_db.cpp.o: ../shopping_db.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/mac/Desktop/HW6/problem1/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "Building CXX object CMakeFiles/problem1_main.dir/shopping_db.cpp.o"
	/Library/Developer/CommandLineTools/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/problem1_main.dir/shopping_db.cpp.o -c /Users/mac/Desktop/HW6/problem1/shopping_db.cpp

CMakeFiles/problem1_main.dir/shopping_db.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/problem1_main.dir/shopping_db.cpp.i"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/mac/Desktop/HW6/problem1/shopping_db.cpp > CMakeFiles/problem1_main.dir/shopping_db.cpp.i

CMakeFiles/problem1_main.dir/shopping_db.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/problem1_main.dir/shopping_db.cpp.s"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/mac/Desktop/HW6/problem1/shopping_db.cpp -o CMakeFiles/problem1_main.dir/shopping_db.cpp.s

CMakeFiles/problem1_main.dir/product.cpp.o: CMakeFiles/problem1_main.dir/flags.make
CMakeFiles/problem1_main.dir/product.cpp.o: ../product.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/mac/Desktop/HW6/problem1/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "Building CXX object CMakeFiles/problem1_main.dir/product.cpp.o"
	/Library/Developer/CommandLineTools/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/problem1_main.dir/product.cpp.o -c /Users/mac/Desktop/HW6/problem1/product.cpp

CMakeFiles/problem1_main.dir/product.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/problem1_main.dir/product.cpp.i"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/mac/Desktop/HW6/problem1/product.cpp > CMakeFiles/problem1_main.dir/product.cpp.i

CMakeFiles/problem1_main.dir/product.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/problem1_main.dir/product.cpp.s"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/mac/Desktop/HW6/problem1/product.cpp -o CMakeFiles/problem1_main.dir/product.cpp.s

CMakeFiles/problem1_main.dir/user.cpp.o: CMakeFiles/problem1_main.dir/flags.make
CMakeFiles/problem1_main.dir/user.cpp.o: ../user.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/mac/Desktop/HW6/problem1/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_7) "Building CXX object CMakeFiles/problem1_main.dir/user.cpp.o"
	/Library/Developer/CommandLineTools/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/problem1_main.dir/user.cpp.o -c /Users/mac/Desktop/HW6/problem1/user.cpp

CMakeFiles/problem1_main.dir/user.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/problem1_main.dir/user.cpp.i"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/mac/Desktop/HW6/problem1/user.cpp > CMakeFiles/problem1_main.dir/user.cpp.i

CMakeFiles/problem1_main.dir/user.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/problem1_main.dir/user.cpp.s"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/mac/Desktop/HW6/problem1/user.cpp -o CMakeFiles/problem1_main.dir/user.cpp.s

# Object files for target problem1_main
problem1_main_OBJECTS = \
"CMakeFiles/problem1_main.dir/test.cpp.o" \
"CMakeFiles/problem1_main.dir/ui.cpp.o" \
"CMakeFiles/problem1_main.dir/admin_ui.cpp.o" \
"CMakeFiles/problem1_main.dir/client_ui.cpp.o" \
"CMakeFiles/problem1_main.dir/shopping_db.cpp.o" \
"CMakeFiles/problem1_main.dir/product.cpp.o" \
"CMakeFiles/problem1_main.dir/user.cpp.o"

# External object files for target problem1_main
problem1_main_EXTERNAL_OBJECTS =

problem1_main: CMakeFiles/problem1_main.dir/test.cpp.o
problem1_main: CMakeFiles/problem1_main.dir/ui.cpp.o
problem1_main: CMakeFiles/problem1_main.dir/admin_ui.cpp.o
problem1_main: CMakeFiles/problem1_main.dir/client_ui.cpp.o
problem1_main: CMakeFiles/problem1_main.dir/shopping_db.cpp.o
problem1_main: CMakeFiles/problem1_main.dir/product.cpp.o
problem1_main: CMakeFiles/problem1_main.dir/user.cpp.o
problem1_main: CMakeFiles/problem1_main.dir/build.make
problem1_main: CMakeFiles/problem1_main.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/mac/Desktop/HW6/problem1/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_8) "Linking CXX executable problem1_main"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/problem1_main.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/problem1_main.dir/build: problem1_main

.PHONY : CMakeFiles/problem1_main.dir/build

CMakeFiles/problem1_main.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/problem1_main.dir/cmake_clean.cmake
.PHONY : CMakeFiles/problem1_main.dir/clean

CMakeFiles/problem1_main.dir/depend:
	cd /Users/mac/Desktop/HW6/problem1/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/mac/Desktop/HW6/problem1 /Users/mac/Desktop/HW6/problem1 /Users/mac/Desktop/HW6/problem1/cmake-build-debug /Users/mac/Desktop/HW6/problem1/cmake-build-debug /Users/mac/Desktop/HW6/problem1/cmake-build-debug/CMakeFiles/problem1_main.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/problem1_main.dir/depend

