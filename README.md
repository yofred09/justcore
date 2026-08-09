# Just Core

Just Core is the server-side API and shared infrastructure layer for Just Vanish, Just Essentials, and future Just mods on Minecraft 1.21.1 with NeoForge.

## Initial API

- Stable `JustCoreApi` entry point
- Companion-module registry
- Optional player-state providers for features such as vanish
- Central append-only audit log at `world/justcore/audit.jsonl`
- Public `StaffActionEvent`
- `/justcore info` and `/justcore modules` diagnostics
- No client installation required

Just Core 0.1.0 is an early development foundation. Just Vanish does not require it yet, and Just Essentials is not publicly available.

## Documentation

Installation, API concepts, modules, player states, auditing, events, and versioning are maintained in the [Just Core Wiki](https://github.com/yofred09/justcore/wiki).

## Distribution

Official compiled releases are distributed through CurseForge and Modrinth. GitHub is used for documentation, issue reporting, security review, and compatibility assessment.

## License

Copyright © 2026 Yo_Fred. All rights reserved. Viewing the source for security review, compatibility assessment, bug reports, and feature suggestions is permitted. Copying, modification, redistribution, derivative works, and commercial reuse are prohibited without written permission. See [LICENSE](LICENSE).
