# Playable peaceful

A Minecraft mod that turns a half-usable difficulty setting into an enjoyable game mode.

It consists of three separate sub-mods. Initially, they were made completely separate. It was done because one part (core) used mixins and author wanted it separate. Now, in modern versions, that is not an issue and there is no point in keeping the mods separate if we expect players to use all of them if they are going to use them at all.

## Playable peaceful: core

Makes health and hunger function mostly the same as on normal difficulty.
* Health doesn't regenerate just because the game is in peaceful mode. High nutrition level will trigger regeneration, unless another mod changed that.
* Nutrition and saturation drain normally. When nutrition hits 0, player starts losing health up to a configurable limit. It that limit is zero, they may die of starvation
* On respawn, player's nutrition is set to previous value. There is a configurable minimum for that, useful in case the player died of starvation.

## Playable peaceful: items

Some items are hard or impossible to obtain, due to no hostile mobs not being around. This mod handles that - you can grow cotton to make string, you can find cure harmless slimes in swamps, you will be approached by traders offering things like ender pearls...

Not all items are made available, that is intentional. Notably, things like rotten flesh and skeleton bones - in a world without zombies, it makes no sense for you to have or need zombie flesh. These is some in structure loot, but you won't have large amounts now.

## Playable peaceful: XP

This mod gives you XP for trying new things, for tasting new food, for using different mounts/vehicles, for harvesting crops, for making some mistakes (only once, of course).
