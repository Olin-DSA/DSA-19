# Day 00

## Learning Goals and Student Input

Help us get to know you and provide input to the class by filling out [this](https://docs.google.com/forms/d/e/1FAIpQLSfNHz1iT64AsXtsn9uTkECSrktoqjLE9tPuC5p5IeRgb3wWaQ/viewform?usp=sf_link) Google form.

For info on the class that is not represented on the syllabus, refer to our intro slides [here](https://docs.google.com/presentation/d/13ju6YX6qzHLha4AQ_oYGW96vx-7IHTSU9Sm7tPHKKtE/edit?usp=sharing).

## Getting Set
All these instructions were executed on an Ubuntu 16.04 and 18.04 systems, so if you do not have an ubuntu partition we recommend you install one. You can find instructions [here](https://linoxide.com/distros/install-ubuntu-18-04-dual-boot-windows-10/) (or one of your friends probably knows how to do it also).

 The aim of this assignments is that you can pull our files off git and run our test cases. So if you can accomplish this another way, that's fine but we won't be able to help you as effectively.

### Git

If you don't have `git` installed:

```
sudo apt update
sudo apt install git-core
git config --global user.name "Firstname Lastname" # your name here
git config --global user.email "mygitemail@example.com" # the email used with your github account
```

Then:

- Follow [these](./GitSetup.md) instructions to fork our repository and add our repo as `upstream`.

**Optional** Complete **at least 10 levels** of [this](http://learngitbranching.js.org/) Git tutorial.

### Java 11

Run the following commands:

```
sudo add-apt-repository ppa:linuxuprising/java
sudo apt update
sudo apt install oracle-java11-installer
sudo apt install oracle-java11-set-default
```

Run `java -version` and ensure you have correctly installed Java 11.

### Installing IntelliJ

The IDE we recommend for this class is IntelliJ. If you have another preferred
IDE, that's fine. Here's how to install IntelliJ:

```
sudo add-apt-repository ppa:ubuntu-desktop/ubuntu-make
sudo apt update
sudo apt install ubuntu-make
umake ide idea
```

Set up IntelliJ according to your preferences!

### Getting started with the code

- Open IntelliJ. If IntelliJ opens a project, click *File > Close Project*. T
- If you don't know how to open IntelliJ, you likely saw something like this when installing:
```
Installing Idea
/home/YOUR_USERNAME/.local/share/umake/ide/idea/bin/idea.sh  
```
 Run `idea.sh` in terminal to start it.
- Once open, chose `Import Project`, navigate to the datastructures folder, select `day00`, and click through the prompts
- If you don't see the Project sidebar on the left, click on `View > Tool Windows > Project`.
- Open up `src/HelloWorld.java`. Click on the `main` method and choose `Run` (it might take a bit to load the run option).

### Debugger

- **Optional but recommended:** Read instructions inside `HelloWorld.java` to play around with IntelliJ's debugging tool. Become at least acquainted with breakpoints, the `Debug` button, the `Variables` window, and the `Step Over`, `Step Into` and `Step Out` buttons.

### If you have errors

- If you have unrecognized imports, right click on the `lib/` folder and click on `Add as Library`
- If you see a yellow bar at the top, click on `Setup SDK` and choose `Java 11`
- If you get errors when importing source files, you may have to disable some android features. This can be done on the main screen under `configure` or if there is a yellow exclamation mark in the bottom right, click on that and follow the prompts
- If you already had an older IntelliJ IDEA installed you should upgrade to the newer one
- If you get the error

> Cannot start compilation: the output path is not specified for module "day00".
> Specify the output path in Configure Project.

Click OK. A new window should open. IntelliJ needs you to specify a place for it to dump compiled Java code. On the left sidebar, choose `Project`. The last option, `Project compiler output`, should be empty (which is why it was complaining). Browse to and choose `day00/out/` as the compiler output folder. If that folder does not exist, simply `cd` into the `day00` directory, and execute `mkdir out/`. Run `main` again.
- If you can't get past an error, feel free to reach out to the teaching team via email or slack

# Assignment Checklist

- [ ] I've filled out [this](https://docs.google.com/forms/d/e/1FAIpQLSfNHz1iT64AsXtsn9uTkECSrktoqjLE9tPuC5p5IeRgb3wWaQ/viewform?usp=sf_link) Google form to provide input and learning goals (also linked at the top of this README)
- [ ] Git is installed.
- [ ] I've forked the DSA-19 repository using [these](./GitSetup.md) instructions
- [ ] I've added the DSA-19 repository as an upstream remote
- [ ] IntelliJ is installed and I've run `HelloWorld.java`
- [ ] **Optional** I've familiarized myself with the debugger.
- [ ] **Optional** I've completed 10 levels of the [Git tutorial](http://learngitbranching.js.org/)
- [ ] I've joined [the DSA channel](https://olin.slack.com/messages/dsa-19) `#dsa-19` on Slack.
- [ ] I've filled out [this](https://docs.google.com/forms/d/e/1FAIpQLSeCqQlQbDWQcAGIcgvcJwXU6TzqCo7rUNqajY5OX8iQ_djlXQ/viewform?usp=sf_link)
