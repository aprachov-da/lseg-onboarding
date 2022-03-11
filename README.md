# IST-BACKEND SERVICE DOCUMENTATION

## Workflows / Steps

IST Workflow is just wrapper for steps. Has owner and list of steps.
IST Step is wrapper for. All licenses added to step are logically grouped and named.

## Tasks

Task - part of work that can be assigned to single user. Сan be created by any user.
Required param to create license is `queue`. After creation license associated to queue.

## Queues

Queue is place where licenses and users meet.
User as single member or member of team can be added to queue. Tasks associated to one queue during creation.

User who is a member of queue can receive all not assigned licenses of this queue as `pending`
User can assign any `pending` license to himself.
Admin user can move licenses between queues after creation.