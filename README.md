# Just Core

Just Core is the server-side API and shared infrastructure layer for Just Vanish, Just Essentials, and future Just mods on Minecraft 1.21.1 with NeoForge.

## API 2

- Stable `JustCoreApi` entry point
- Companion-module registry
- Mutable player-state providers for features such as vanish
- Central append-only audit log at `world/justcore/audit.jsonl`
- Public `StaffActionEvent`
- `/justcore info` and `/justcore modules` diagnostics
- No client installation required

Just Core 0.2.0 is required by Just Vanish 1.3.1+ and Just Essentials 0.3.1+. It keeps shared contracts, module discovery, player states, and staff auditing independent from either feature mod.

## Documentation

Installation, API concepts, modules, player states, auditing, events, and versioning are maintained in the [Just Core Wiki](https://github.com/yofred09/justcore/wiki).

## Distribution

Official compiled releases are distributed through CurseForge and Modrinth. GitHub is used for documentation, issue reporting, security review, and compatibility assessment.

## Community & Support

Join the [official Discord community](https://discord.gg/R5VnN7Rn5H) for help, discussion and development updates.

## License

Copyright © 2026 Yo_Fred. All rights reserved. Viewing the source for security review, compatibility assessment, bug reports, and feature suggestions is permitted. Copying, modification, redistribution, derivative works, and commercial reuse are prohibited without written permission. See [LICENSE](LICENSE).
