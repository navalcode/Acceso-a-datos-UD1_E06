# Relationships: ownership before presentation

These modules are source/console examples. The reading path begins with a model change and its observable inverse collection, then crosses the persistence boundary. README English/Spanish uses concrete case-sensitive module paths and separates pure object-graph checks, stored-state journeys and the original context smoke tests. It adds no unrelated GUI, image, typeface or animation.

An attachment updates the previous owner, current owner and inverse list together. Repeating it is idempotent for that object. Removing through an unrelated owner does not erase the current association. Existing public helper signatures remain intact, and null attachments fail before changing a graph.

In-memory consistency and persisted consistency are separate checks. JPA tests flush, clear and reload both sides using the pinned Hibernate/H2 provider. Product and teacher transfers are visible from the previous/new parent; video transfer and orphan removal are checked independently, retaining the original cascade/orphan settings. The tests use the managed child after merge, rather than assuming the pre-merge reference received a generated ID.

Original coursework packages, bootstrap data/messages and history stay in place. The source does not claim portable behavior across every provider or expose a production API. Native Markdown, concrete commands and scoped evidence are the presentation for this surface.
