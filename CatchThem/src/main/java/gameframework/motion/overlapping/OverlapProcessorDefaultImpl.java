package gameframework.motion.overlapping;

import gameframework.motion.IntersectTools;
import gameframework.motion.SpeedVector;
import gameframework.motion.GameMovable;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OverlapProcessorDefaultImpl implements OverlapProcessor {

	/**
	 * These two lists contain all overlappables for which we want to compute
	 * overlaps. We distinguish between movable and non-movable because two
	 * non-movables never overlap.
	 */
	protected ConcurrentLinkedQueue<Overlappable> nonMovableOverlappables;
	protected ConcurrentLinkedQueue<Overlappable> movableOverlappables;

	protected OverlapRulesApplier overlapRules;

	public OverlapProcessorDefaultImpl() {
		nonMovableOverlappables = new ConcurrentLinkedQueue<>();
		movableOverlappables = new ConcurrentLinkedQueue<>();
	}

	@Override
	public void addOverlappable(Overlappable p) {
		if (p.isMovable()) {
			movableOverlappables.add(p);
		} else {
			nonMovableOverlappables.add(p);
		}
	}

	@Override
	public void removeOverlappable(Overlappable p) {
		if (p.isMovable()) {
			movableOverlappables.remove(p);
		} else {
			nonMovableOverlappables.remove(p);
		}
	}

	@Override
	public void setOverlapRules(OverlapRulesApplier overlapRules) {
		this.overlapRules = overlapRules;
	}

	// for optimization purpose : prevents to compute two times the overlaps
	private List<Overlappable> movablesTmp;

	@Override
	public void processOverlapsAll() {
		List<Overlap> overlaps = new ArrayList<>();
		movablesTmp = new ArrayList<>(movableOverlappables);
		for (Overlappable movableOverlappable : movableOverlappables) {
			movablesTmp.remove(movableOverlappable);
			computeOneOverlap(movableOverlappable, overlaps);
		}
		overlapRules.applyOverlapRules(overlaps);
	}

	protected void computeOneOverlap(Overlappable movableOverlappable,
			List<Overlap> overlaps) {
		Area overlappableArea;
		Rectangle boundingBoxOverlappable;
		assert movableOverlappable.isMovable();
		Shape intersectShape = intersectionComputation(movableOverlappable);

		overlappableArea = new Area(intersectShape);
		boundingBoxOverlappable = intersectShape.getBounds();

		overlappableArea = new Area(intersectShape);
		boundingBoxOverlappable = intersectShape.getBounds();

		computeOneOverlapMovables(movableOverlappable, overlaps, boundingBoxOverlappable, overlappableArea);
		computeOneOverlapNonMovableOverlappables(movableOverlappable, overlaps, boundingBoxOverlappable, overlappableArea);
	}

	protected void computeOneOverlapMovables(Overlappable movableOverlappable,
			List<Overlap> overlaps, Rectangle boundingBoxOverlappable,
			Area overlappableArea){

		Rectangle boundingBoxTarget;
		for (Overlappable targetOverlappable : movablesTmp) {
			if (targetOverlappable != movableOverlappable) {
				Shape targetShape;
				targetShape = IntersectTools.getIntersectShape(
						(GameMovable) targetOverlappable, new SpeedVector(
								((GameMovable) targetOverlappable).getSpeedVector()
										.getDirection(),
								-((GameMovable) targetOverlappable)
										.getSpeedVector().getSpeed()));
				boundingBoxTarget = targetShape.getBounds();
				addOverlapsIfIntersect(boundingBoxOverlappable, boundingBoxTarget, targetShape, overlappableArea,
						overlaps, movableOverlappable, targetOverlappable);
			}
		}
	}

	protected void computeOneOverlapNonMovableOverlappables(Overlappable movableOverlappable,
			List<Overlap> overlaps, Rectangle boundingBoxOverlappable,
			Area overlappableArea){
		Rectangle boundingBoxTarget;
		for (Overlappable targetNonMovableOverlappable : nonMovableOverlappables) {
			if (targetNonMovableOverlappable != movableOverlappable) {
				// NOTE I don't see how this test could fail
				Shape targetShape;
				targetShape = targetNonMovableOverlappable.getBoundingBox();
				boundingBoxTarget = targetShape.getBounds();

				addOverlapsIfIntersect(boundingBoxOverlappable, boundingBoxTarget, targetShape, overlappableArea,
						overlaps, movableOverlappable, targetNonMovableOverlappable);
			}
		}
	}

	protected void addOverlapsIfIntersect(Rectangle boundingBoxOverlappable, Rectangle boundingBoxTarget,
			Shape targetShape, Area overlappableArea, List<Overlap> overlaps,
			Overlappable movableOverlappable, Overlappable targetOverlappable){
		if (boundingBoxOverlappable.intersects(boundingBoxTarget)) {
			Area targetArea = new Area(targetShape);
			targetArea.intersect(overlappableArea);
			if (!targetArea.isEmpty()) {
				// NOTE I don't see how this test could fail
				overlaps.add(new Overlap(movableOverlappable,targetOverlappable));
			}
		}
	}

	protected Shape intersectionComputation(Overlappable movableOverlappable) {
		assert movableOverlappable.isMovable();
		GameMovable movable = (GameMovable) movableOverlappable;
		SpeedVector speedVector = movable.getSpeedVector();
		SpeedVector oppositeSpeedVector = new SpeedVector(
				speedVector.getDirection(), -1 * speedVector.getSpeed());
		return IntersectTools.getIntersectShape(movable, oppositeSpeedVector);
	}
}
