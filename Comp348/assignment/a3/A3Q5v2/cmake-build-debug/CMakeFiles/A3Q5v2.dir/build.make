# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.12

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2018.2.6\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2018.2.6\bin\cmake\win\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "C:\Users\owner\OneDrive - Concordia University - Canada\ProgrammingProjects\ConcordiaCourse\Comp348\assignment\a3\A3Q5v2"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "C:\Users\owner\OneDrive - Concordia University - Canada\ProgrammingProjects\ConcordiaCourse\Comp348\assignment\a3\A3Q5v2\cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/A3Q5v2.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/A3Q5v2.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/A3Q5v2.dir/flags.make

CMakeFiles/A3Q5v2.dir/main.c.obj: CMakeFiles/A3Q5v2.dir/flags.make
CMakeFiles/A3Q5v2.dir/main.c.obj: ../main.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="C:\Users\owner\OneDrive - Concordia University - Canada\ProgrammingProjects\ConcordiaCourse\Comp348\assignment\a3\A3Q5v2\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/A3Q5v2.dir/main.c.obj"
	C:\MinGW\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\A3Q5v2.dir\main.c.obj   -c "C:\Users\owner\OneDrive - Concordia University - Canada\ProgrammingProjects\ConcordiaCourse\Comp348\assignment\a3\A3Q5v2\main.c"

CMakeFiles/A3Q5v2.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/A3Q5v2.dir/main.c.i"
	C:\MinGW\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "C:\Users\owner\OneDrive - Concordia University - Canada\ProgrammingProjects\ConcordiaCourse\Comp348\assignment\a3\A3Q5v2\main.c" > CMakeFiles\A3Q5v2.dir\main.c.i

CMakeFiles/A3Q5v2.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/A3Q5v2.dir/main.c.s"
	C:\MinGW\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "C:\Users\owner\OneDrive - Concordia University - Canada\ProgrammingProjects\ConcordiaCourse\Comp348\assignment\a3\A3Q5v2\main.c" -o CMakeFiles\A3Q5v2.dir\main.c.s

# Object files for target A3Q5v2
A3Q5v2_OBJECTS = \
"CMakeFiles/A3Q5v2.dir/main.c.obj"

# External object files for target A3Q5v2
A3Q5v2_EXTERNAL_OBJECTS =

A3Q5v2.exe: CMakeFiles/A3Q5v2.dir/main.c.obj
A3Q5v2.exe: CMakeFiles/A3Q5v2.dir/build.make
A3Q5v2.exe: CMakeFiles/A3Q5v2.dir/linklibs.rsp
A3Q5v2.exe: CMakeFiles/A3Q5v2.dir/objects1.rsp
A3Q5v2.exe: CMakeFiles/A3Q5v2.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="C:\Users\owner\OneDrive - Concordia University - Canada\ProgrammingProjects\ConcordiaCourse\Comp348\assignment\a3\A3Q5v2\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable A3Q5v2.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\A3Q5v2.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/A3Q5v2.dir/build: A3Q5v2.exe

.PHONY : CMakeFiles/A3Q5v2.dir/build

CMakeFiles/A3Q5v2.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\A3Q5v2.dir\cmake_clean.cmake
.PHONY : CMakeFiles/A3Q5v2.dir/clean

CMakeFiles/A3Q5v2.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" "C:\Users\owner\OneDrive - Concordia University - Canada\ProgrammingProjects\ConcordiaCourse\Comp348\assignment\a3\A3Q5v2" "C:\Users\owner\OneDrive - Concordia University - Canada\ProgrammingProjects\ConcordiaCourse\Comp348\assignment\a3\A3Q5v2" "C:\Users\owner\OneDrive - Concordia University - Canada\ProgrammingProjects\ConcordiaCourse\Comp348\assignment\a3\A3Q5v2\cmake-build-debug" "C:\Users\owner\OneDrive - Concordia University - Canada\ProgrammingProjects\ConcordiaCourse\Comp348\assignment\a3\A3Q5v2\cmake-build-debug" "C:\Users\owner\OneDrive - Concordia University - Canada\ProgrammingProjects\ConcordiaCourse\Comp348\assignment\a3\A3Q5v2\cmake-build-debug\CMakeFiles\A3Q5v2.dir\DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/A3Q5v2.dir/depend

