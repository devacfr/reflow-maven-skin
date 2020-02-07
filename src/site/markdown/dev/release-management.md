# Release Management

The workflow used is Gitflow workflow from Vincent Driessen at [nvie](http://nvie.com/). This workflow is supported in project by serveral tools:

- `Git`, Git extension [git-flow](https://github.com/nvie/gitflow).
- `maven` and `JGit Flow` maven plugin, allows executing Gitflow workflow actions according to the configuration stored in maven `pom.xml`.

The Gitflow Workflow defines a strict branching model designed around the project release. While somewhat more complicated than the **Feature Branch Workflow**, this provides a robust framework for managing larger projects.
This workflow doesn’t add any new concepts or commands beyond what’s required for the Feature Branch Workflow. Instead, it assigns very specific roles to different branches and defines how and when they should interact. In addition to feature branches, it uses individual branches for preparing, maintaining, and recording releases. Of course, you also get to leverage all the benefits of the Feature Branch Workflow: pull requests, isolated experiments, and more efficient collaboration.

## Gitflow Workflow In Action

The Gitflow Workflow still uses a central repository as the communication hub for all developers. And, as in the other workflows, developers work locally and push branches to the central repo. The only difference is the branch structure of the project.

Instead of a single `master` branch, this workflow uses two branches to record the history of the project. The `master` branch stores the official release history, and the `develop` branch serves as an integration branch for features. It's also convenient to tag all commits in the master branch with a version number.

![Gitflow Workflow][git-workflow]

The rest of this workflow revolves around the distinction between these two branches.

### Feature Branches

Each new feature should reside in its own branch, which can be pushed to the central repository for backup/collaboration. But, instead of branching off of `master`, feature branches use develop as their parent branch. When a feature is complete, it gets merged back into `develop`. Features should never interact directly with master.

Common conventions:

- **branch off**: `develop`
- **merge into**: `develop`
- **naming convention**: `feature/*`

![Gitflow Feature Branch][workflow-features]

After the feature branch is merged, the version on `develop` is `1.3.0-unstable.3`. This is due to develop running in `continuous deployment mode`.

#### Using Feature Branch

In general, one issue in GitHub corresponds to one feature branch in `Git`. Instead to create new branch directly from `Git`, do the following steps:

1. Open a terminal, by changing directory to the root of project.
2. Create feature branch using `maven-jgitflow-plugin`.
3. Give name to the branch with prefix of a specific issue ID as `REFLOW-1234-add-new-feature` to create as many two-way links between `Git` changeset, `GitHub` issue and **CI** build.

```bash
$ mvn jgitflow:feature-start
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO]
[INFO] Foo project
[INFO] core
[INFO] webapp
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Foo project 1.0.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- jgitflow-maven-plugin:1.0-m5.1:feature-start (default-cli) @foo ---
[INFO] (develop) Checking for SNAPSHOT version in projects...
[INFO] (develop) Checking dependencies and plugins for snapshots ...
What is the feature branch name? feature/: REFLOW-78-new-feature
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] Foo project ............................. SUCCESS [ 56.666 s]
[INFO] core .................................... SKIPPED
[INFO] webapp .................................. SKIPPED
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 59.370 s
[INFO] Finished at: 2015-08-06T10:12:28+02:00
[INFO] Final Memory: 11M/39M
[INFO] ------------------------------------------------------------------------
```

Tips, click on **Terminal** button in SourceTree to open a `Bash` command prompt directly on the root directory of project.

This command creates a new feature branch; prompts for the branch name which will take the format `feature/{branch name}`. Add `-DpushFeatures=true` to push the branch to origin automatically.

When the feature is complete, execute the following command to merge the feature branch to `develop` branch:

```bash
$ mvn jgitflow:feature-finish
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO]
[INFO] Foo project
[INFO] core
[INFO] webapp
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Foo project 1.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- jgitflow-maven-plugin:1.0-m5.1:feature-finish (default-cli) @ foo ---
What is the feature branch name? feature/
1:  78-new-feature
2:  47-another-feature
Choose a number (1/2) [1]: 1
[INFO] running jgitflow feature finish...
[INFO] Executing: cmd.exe /X /C "F:\development\tools\local\maven\apache-maven-3.2.3\bin\..\bin\mvn -s C:\Temp\release-settings6432120503142207031.xml clean install --no-plugin-updates -Penforcer-rules -Pjcenter"
...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] Foo project ............................. SUCCESS [11:38 min]
[INFO] core .................................... SKIPPED
[INFO] webapp .................................. SKIPPED
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 11:39 min
[INFO] Finished at: 2015-08-06T11:06:51+02:00
[INFO] Final Memory: 12M/33M
[INFO] ------------------------------------------------------------------------
```

This command executes tests and merges a feature branch back into the `develop` branch and add `-DpushFeatures=true` to push the branch to origin automatically.

Note that feature branches combined with the `develop` branch is, for all intents and purposes, the Feature Branch Workflow.

### Release Branches

Using a dedicated branch to prepare releases makes it possible for one team to polish the current release while another team continues working on features for the next release. It also creates well-defined phases of development (e.g., it‘s easy to say, “this week we’re preparing for version 4.0” and to actually see it in the structure of the repository).

Common conventions:

- **branch off**: `develop`
- **merge into**: `master` and `develop`
- **naming convention**: `release/{version}` eg `release/2.2.0` 

![Gitflow Release Branch][workflow-release]

The release version is extracted from branch name or the first version tag placed on the `release` branch.
Note that at least one version tag required on the branch. the recommended initial tag is `{releaseVersion}-alpha1`.

#### Release Checklist

There are any Tasks to do while the Release Phase:

- Publish distribution package for user acceptance testing and bug fixing.
- Execute functional tests.
- Update and review  documentation.
- Update CHANGELOG distribution file and release notes documentation.
- update `latest` version in Apache Server configuration.
- Release version in `GitHub`.
- Announcements.
- Congratulations.

#### Using Release Branch

Once `develop` has acquired enough features for a release (or a predetermined release date is approaching), you fork a release branch off of `develop`. Creating this branch starts the next release cycle, so no new features can be added after this point—only bug fixes, documentation generation, and other release-oriented tasks should go in this branch.

```bash

$ mvn clean install -PskipTests
   -> install the last version in your local repository
...
$ mvn jgitflow:release-start -DreleaseVersion=1.1.0
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO]
[INFO] Foo project
[INFO] core
[INFO] webapp
[INFO] doc
[INFO] Functional Test Module
[INFO] Foo Distribution
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Foo project 1.1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- jgitflow-maven-plugin:1.0-m5.1:release-start (default-cli) @ Foo project ---
[INFO] (develop) Checking for SNAPSHOT version in projects...
[INFO] (develop) Checking dependencies and plugins for snapshots ...
[INFO] (release/1.1.0) adding snapshot to pom versions...
[INFO] (release/1.1.0) updating poms for all projects...
[INFO] turn on debug logging with -X to see exact changes
[INFO] (release/1.1.0) updating pom for Foo project
[INFO] (release/1.1.0) updating pom for core
[INFO] (release/1.1.0) updating pom for webapp
[INFO] (release/1.1.0) updating pom for doc
[INFO] (release/1.1.0) updating pom for Functional Test Module
[INFO] (release/1.1.0) updating pom for Foo Distribution
What is the development version for "Foo project"? (org.devacfr.foo:foo) [1.1.1-SNAPSHOT]: 1.2.0-SNAPSHOT
[INFO] (develop) updating poms with next development version...
[INFO] (develop) updating poms for all projects...
[INFO] turn on debug logging with -X to see exact changes
[INFO] (develop) updating pom for Foo project
[INFO] (develop) updating pom for core
[INFO] (develop) updating pom for webapp
[INFO] (develop) updating pom for doc
[INFO] (develop) updating pom for Functional Test Module
[INFO] (develop) updating pom for Foo Distribution
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] Foo project ........................................ SUCCESS [ 56.666 s]
[INFO] core ............................................... SKIPPED
[INFO] webapp ............................................. SKIPPED
[INFO] doc ................................................ SKIPPED
[INFO] Functional Test Module ............................. SKIPPED
[INFO] Foo Distribution ................................... SKIPPED
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 51.952 s
[INFO] Finished at: 2015-10-20T10:10:39+02:00
[INFO] Final Memory: 11M/37M
[INFO] ------------------------------------------------------------------------
```

Once it's ready to ship, the release gets merged into `master` and tagged with a version number. In addition, it should be merged back into `develop`, which may have progressed since the release was initiated.

```bash
$ mvn jgitflow:release-finish -Prelease-offline
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO]
[INFO] Foo project
[INFO] core
[INFO] webapp
[INFO] doc
[INFO] Functional Test Module
[INFO] Foo Distribution
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building TPD project 1.1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- jgitflow-maven-plugin:1.0-m5.1:release-finish (default-cli) @ Foo project ---
[INFO] running jgitflow release finish...
[INFO] (release/1.1.0) Updating poms for RELEASE
[INFO] (release/1.1.0) removing snapshot from pom versions...
[INFO] (release/1.1.0) updating poms for all projects...
[INFO] turn on debug logging with -X to see exact changes
[INFO] (release/1.1.0) updating pom for Foo project
[INFO] (release/1.1.0) updating pom for core
[INFO] (release/1.1.0) updating pom for webapp
[INFO] (release/1.1.0) updating pom for doc
[INFO] (release/1.1.0) updating pom for Foo Distribution
[INFO] Executing: cmd.exe /X /C "F:\development\tools\local\maven\apache-maven-3.2.5\bin\..\bin\mvn -s C:\Temp\release-settings2749399463239700451.xml"
...
[INFO] (develop) copying pom versions...
[INFO] (develop) updating poms for all projects...
[INFO] turn on debug logging with -X to see exact changes
[INFO] (develop) updating pom for Foo project
[INFO] (develop) updating pom for core
[INFO] (develop) updating pom for webapp
[INFO] (develop) updating pom for doc
[INFO] (develop) updating pom for Foo Distribution
[INFO] copying pom versions...
[INFO] (develop) updating poms for all projects...
[INFO] turn on debug logging with -X to see exact changes
[INFO] (develop) updating pom for Foo project
[INFO] (develop) updating pom for core
[INFO] (develop) updating pom for webapp
[INFO] (develop) updating pom for doc
[INFO] (develop) updating pom for Foo Distribution
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] Foo project ........................................ SUCCESS [ 56.666 s]
[INFO] core ............................................... SKIPPED
[INFO] webapp ............................................. SKIPPED
[INFO] doc ................................................ SKIPPED
[INFO] Foo Distribution ................................... SKIPPED
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 11:39 min
[INFO] Finished at: 2015-08-06T11:06:51+02:00
[INFO] Final Memory: 12M/33M
[INFO] ------------------------------------------------------------------------
```

### Maintenance Branches

Maintenance or “hotfix” branches are used to quickly patch production releases. This is the only branch that should fork directly off of `master`. As soon as the fix is complete, it should be merged into both `master` and `develop` (or the current release branch), and `master` should be tagged with an updated version number.

Common conventions:

- **branch off**: `master`
- **merge into**: `master`
- **naming convention**: `hotfix/{version}` eg `hotfix/2.0.1` 

![Gitflow Maintenance Branch][workflow-hotfix]

#### Using Maintenance Branch

In general, one BUGFIX issue in GitHub corresponds to one maintenance branch in `Git`, but you can include more than one BUGFIX issues to a same maintenance branch. The main Gitflow restriction is you couldn't create a second maintenance branch in same time whether one already exists. Instead to create new branch directly from `Git`, do the following steps:

1. Open a terminal, by changing directory to the root of project.
2. Create maintenance branch using `maven-jgitflow-plugin`.   

```bash
$ mvn jgitflow:hotfix-start
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO]
[INFO] Foo project
[INFO] core
[INFO] webapp
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Foo project 1.0.2-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] (master) Checking for RELEASE version in projects...
[INFO] (master) Checking dependencies and plugins for snapshots ...
What is the hotfix version for "Foo project"? (org.devacfr.foo:foo) [1.0.3]: 1.0.3
...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] Foo project ........................................ SUCCESS [ 56.666 s]
[INFO] core ............................................... SKIPPED
[INFO] webapp ............................................. SKIPPED
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 59.370 s
[INFO] Finished at: 2015-08-06T10:12:28+02:00
[INFO] Final Memory: 11M/39M
[INFO] ------------------------------------------------------------------------
```

This command creates a new maintenance branch; prompts for the hotfix version (i.e. branch name) which will take the format `hotfix/{version}`.

When the hotfix is complete, execute the following command to merge the maintenance branch to `develop` and `master` branches:

```bash
$ mvn jgitflow:hotfix-finish
```

Having a dedicated line of development for bug fixes lets your team address issues without interrupting the rest of the workflow or waiting for the next release cycle. You can think of maintenance branches as ad hoc release branches that work directly with `master`.

## References

- [GitVersion Docs](http://gitversion.readthedocs.org/en/latest/)
- [JGit Flow Maven Plugin Documentation](http://jgitflow.bitbucket.org/)
- [Maven Git Flow Plugin for Better Releases](http://blogs.atlassian.com/2013/05/maven-git-flow-plugin-for-better-releases/)
- [Making a release with Maven JGitFlow plugin](http://kentorjava.com/2013/11/24/making-a-release-with-maven-jgitflow-plugin/)
- [Painless Maven project releases with Maven GitFlow Plugin](http://george-stathis.com/2013/11/09/painless-maven-project-releases-with-maven-gitflow-plugin/)

[git-workflow]: images/git-workflow.png
[workflow-features]: images/workflow-features.png
[workflow-hotfix]: images/workflow-hotfix.png
[workflow-release]: images/workflow-release.png

[nvie]: http://nvie.com/
[semver]: http://semver.org/
