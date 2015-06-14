function mutationChildren = goldenMutation(parents,options,GenomeLength,FitnessFcn,state,thisScore,thisPopulation,mutationRate)
%золота мутація
mutationChildren = zeros(length(parents),GenomeLength);
    for i=1:length(parents)
        child = thisPopulation(parents(i),:);
	mutationPoints = floor( 0.61803*length(child) )
        %mutationPoints = find(rand(1,length(child)));
	p1 = child(mutationPoints)
	p2 = child(mutationPoints+1)
	child(mutationPoints) = p2;
	child(mutationPoints+1) = p1;
        mutationChildren(i,:) = child;
    end
    
end
