cmake_minimum_required(VERSION 3.0.0)
project(problem2 VERSION 0.1.0)

include(CTest)
enable_testing()

add_executable(problem2_main main.cpp app.cpp User.cpp User.h FrontEnd.cpp FrontEnd.h BackEnd.cpp BackEnd.h View.cpp View.h)
add_executable(problem2_test test.cpp app.cpp User.cpp User.h)

file(REMOVE_RECURSE ${CMAKE_BINARY_DIR}/data)
file(REMOVE_RECURSE ${CMAKE_BINARY_DIR}/test)
file(COPY data DESTINATION .)
file(COPY test DESTINATION .)

set(CMAKE_CXX_FLAGS "-std=c++17")

set(CPACK_PROJECT_NAME ${PROJECT_NAME})
set(CPACK_PROJECT_VERSION ${PROJECT_VERSION})
include(CPack)
