# discord-game-sdk4j

[![](https://jitpack.io/v/ArenaReturns/discord-game-sdk4j.svg)](https://jitpack.io/#ArenaReturns/discord-game-sdk4j)

This project provides Java bindings for the
[Discord GameSDK](https://discordapp.com/developers/docs/game-sdk/sdk-starter-guide).

To be honest I'm not sure if people even need this, because Discord apparently discarded its game store idea.

But maybe the activity, overlay, user, and relationship features could be useful to some people.

## Rich Presence

If you are just looking for an alternative to the deprecated [Discord Rich Presence SDK](https://discord.com/developers/docs/rich-presence/how-to),
head over to the [ActivityExample.java](examples/ActivityExample.java)!

## Features of the SDK

**Some of the features are deprecated by Discord as of Wed, 09 Nov 2022 and will be decommissioned and stop working on Tuesday May 2, 2023.
They are marked with :broken_heart: in the table.
Those already implemented will most likely continue to work until Discord decommissions them.
Those not implemented will remains such, as putting work into features which will end working in less than a year does not seem worth it to me.**

**The Java-only implementation currently does not support all features fully.
I am aiming to fully implement all non-deprecated features soon.**

| Feature                                                                     | State                                                   | Example                                                                                                                                  |
|-----------------------------------------------------------------------------|---------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------|
| [Achievements](https://discord.com/developers/docs/game-sdk/achievements)   | :x: not implemented :broken_heart:                      |                                                                                                                                          |
| [Activities](https://discord.com/developers/docs/game-sdk/activities)       | :white_check_mark: partially implemented                | [ActivityExample.java](examples/ActivityExample.java)                                                                                    |
| [Applications](https://discord.com/developers/docs/game-sdk/applications)   | :x: not implemented :broken_heart:                      |                                                                                                                                          |
| [Voice](https://discord.com/developers/docs/game-sdk/discord-voice)         | :white_check_mark: partially implemented :broken_heart: |                                                                                                                                          |
| [Images](https://discord.com/developers/docs/game-sdk/images)               | :heavy_check_mark: implemented :broken_heart:           | none yet :cry: (see [``imageTest()``](src/test/java/de/jcm/discordgamesdk/DiscordTest.java#L417) for now)                                |
| [Lobbies](https://discord.com/developers/docs/game-sdk/lobbies)             | :x: not implemented :broken_heart:                      |                                                                                                                                          |
| [Networking](https://discord.com/developers/docs/game-sdk/networking)       | :x: not implemented :broken_heart:                      |                                                                                                                                          |
| [Overlay](https://discord.com/developers/docs/game-sdk/overlay)             | :heavy_check_mark: implemented                          | none yet :cry: (see [``overlayTest()``](src/test/java/de/jcm/discordgamesdk/DiscordTest.java#L289) for now)                              |
| [Relationships](https://discord.com/developers/docs/game-sdk/relationships) | :heavy_check_mark: implemented                          | [RelationshipExample.java](examples/RelationshipExample.java), [FriendNotificationExample.java](examples/FriendNotificationExample.java) |
| [Storage](https://discord.com/developers/docs/game-sdk/storage)             | :x: not implemented :broken_heart:                      |                                                                                                                                          |
| [Store](https://discord.com/developers/docs/game-sdk/store)                 | :x: not implemented :broken_heart:                      |                                                                                                                                          |
| [Users](https://discord.com/developers/docs/game-sdk/users)                 | :white_check_mark: partially implemented                | none yet :cry: (see [``userTest()``](src/test/java/de/jcm/discordgamesdk/DiscordTest.java#L216) for now)                                 |

I will try to work on features that are not implemented yet soon,
but the remaining ones are quite difficult to test,
so I don't know how much progress I can make on them.

## Installation 

### Pre-compiled

#### Maven, Gradle and other build tools

There are pre-compiled builds on [JitPack](https://jitpack.io/#ArenaReturns/discord-game-sdk4j)
together with instructions how to use them for all common build tools.

#### Manual installation

For projects not using any build tools, download a pre-compiled JAR-file (``discord-game-sdk4j-<version>.jar``)
from the [releases page](https://github.com/ArenaReturns/discord-game-sdk4j/releases).

If you want, you can also download the JavaDocs (``discord-game-sdk4j-<version>-javadoc.jar``) or
the sources (``discord-game-sdk4j-<version>-sources.jar``).

After downloading those JARs, just add the main JAR to your project's classpath and optionally
attach sources or JavaDocs.

### Building from source

To install the library from source first of all clone the repository:
```shell script
git clone https://github.com/ArenaReturns/discord-game-sdk4j.git
```

Finally build (and install) the library with Maven:
````shell script
mvn install
````

If you want to skip the tests (sometimes they fail for really weird reasons), add ``-DskipTests`` to the command arguments.

## Usage

Create a ``Core`` object to start using the library:
````java
try(CreateParams params = new CreateParams())
{
    params.setClientID(<your application ID as a long>);
    params.setFlags(CreateParams.getDefaultFlags());

    try(Core core = new Core(params))
    {
        // do something with your Core
    }
}
````

For real examples see the ``examples/`` directory in this repository.
