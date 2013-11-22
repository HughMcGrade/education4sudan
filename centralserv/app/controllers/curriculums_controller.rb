class CurriculumsController < ApplicationController

  def index
    @grade = Grade.find(params[:id])
  end

  def new
    @curriculum = Curriculum.new
    @grade = Grade.find(params[:id])
  end

  def show
    @curriculum = Curriculum.find(params[:id])
  end

  def create
    @curriculum = Curriculum.create(curriculum_params)
    redirect_to grade_path(@curriculum.grade_id), :notice => "Curriculum created successfully!"
  end

  private

  def curriculum_params
    params.require(:curriculum).permit(:title, :week, :content, :grade_id)
  end

end
