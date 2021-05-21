# Prisma plugin for the IntelliJ Platform

Prisma Schema Language support for WebStorm, GoLand, and other IDEs based on IntelliJ Platform.

## Installation

This plugin is available in the JetBrains marketplace. Open
`Settings > Plugins > Marketplace` in your IDE, search for _Prisma_
and install the plugin.

## Features

For now, this plugin only provides syntax highlighting but more are yet to come:

- autocompletion
- _go to definition_ and refactoring
- color settings page
- anything you want! Just create an issue ;)

## Development

This plugin is built using [JetBrains' Grammar-Kit](https://github.com/JetBrains/Grammar-Kit), after cloning, follow
their [general usage instructions](https://github.com/JetBrains/Grammar-Kit#general-usage-instructions) to generate the
relevant Java classes. Make sure to install the Grammar Kit Plugin for IntelliJ!

The files defining the Prisma schema language can be found under `src/main/java/org/intellij/sdk/language/Prisma.bnf`
and `src/main/java/org/intellij/sdk/language/Prisma.flex`

For more information on how to build and test your plugin, see the
[Building Plugins with Gradle Guide](https://plugins.jetbrains.com/docs/intellij/gradle-build-system.html).
